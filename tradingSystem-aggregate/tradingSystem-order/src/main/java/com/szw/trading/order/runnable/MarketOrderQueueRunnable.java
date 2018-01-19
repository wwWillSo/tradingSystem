package com.szw.trading.order.runnable;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.szw.trading.persistence.entity.Order;
import com.szw.trading.persistence.entity.RealTimeMarketdata;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.constants.OrderQueue;
import com.szw.trading.web.constants.StatusCode;
import com.szw.util.HttpClientUtils;
import com.szw.util.RedisCacheUtil;


public class MarketOrderQueueRunnable implements Callable<MarketOrderQueueRunnable> {

	private final Logger log = Logger.getLogger(MarketOrderQueueRunnable.class);

	private RedisCacheUtil<Order> redisCacheUtil;

	private String getMarketDataByCodeUrl;

	private String tradeUrl;

	public MarketOrderQueueRunnable(RedisCacheUtil<Order> redisCacheUtil, String getMarketDataByCodeUrl, String tradeUrl) {
		this.redisCacheUtil = redisCacheUtil;
		this.getMarketDataByCodeUrl = getMarketDataByCodeUrl;
		this.tradeUrl = tradeUrl;
	}

	@Override
	public MarketOrderQueueRunnable call() throws Exception {

		while (true) {
			Order order = redisCacheUtil.popCacheList(OrderQueue.MARKET_ORDER_QUEUE.name());
			try {

				if (null == order) {
					continue;
				}

				String entity = HttpClientUtils.doGet(getMarketDataByCodeUrl + order.getStockCode());
				RealTimeMarketdata marketdata = JSON.parseObject(entity, RealTimeMarketdata.class);
				order.setOrderPrice(marketdata.getNow());

				BigDecimal cost = order.getOrderPrice().multiply(order.getOrderHand());
				BigDecimal serv = cost.multiply(BigDecimal.valueOf(0.001));

				order.setOrderAmount(cost);
				order.setServiceAmount(serv);

				// 调用trade接口
				String returnStr = HttpClientUtils.doPost(tradeUrl, JSON.toJSONString(order));
				if (null != returnStr) {
					log.info("【市价单交易请求】returnStr：" + returnStr);

					try {
						Response resp = JSON.parseObject(returnStr, Response.class);
						if (!resp.get_ReturnCode().equals(StatusCode.SUCCESS.getCode())) {
							log.info("【市价单交易请求】交易失败，order：" + JSON.toJSONString(order));
						} else {
							log.info("【市价单交易请求】交易成功，order：" + JSON.toJSONString(order));
						}
					} catch (Exception e) {
						log.info("【市价单交易请求】请求失败，重新进入市价单队列，order：" + JSON.toJSONString(order));
						redisCacheUtil.pushCacheList(OrderQueue.MARKET_ORDER_QUEUE.name(), order);
					}

				} else {
					log.info("【市价单交易请求】请求失败，重新进入市价单队列，order：" + JSON.toJSONString(order));
					redisCacheUtil.pushCacheList(OrderQueue.MARKET_ORDER_QUEUE.name(), order);
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.info("【市价单交易请求】请求失败，重新进入市价单队列，order：" + JSON.toJSONString(order));
				redisCacheUtil.pushCacheList(OrderQueue.MARKET_ORDER_QUEUE.name(), order);
			} finally {
			}
		}
	}
}
