package com.szw.trading.order.runnable;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.szw.trading.persistence.entity.Order;
import com.szw.trading.persistence.entity.RealTimeMarketdata;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.constants.OrderQueueName;
import com.szw.trading.web.constants.StatusCode;
import com.szw.util.HttpClientUtils;
import com.szw.util.RedisCacheUtil;


public class LimitOrderQueueRunnable implements Runnable {

	private final Logger log = Logger.getLogger(LimitOrderQueueRunnable.class);

	private RedisCacheUtil<Order> redisCacheUtil;

	private String marketUrl;

	private String title;

	private String tradeUrl;

	public LimitOrderQueueRunnable(RedisCacheUtil<Order> redisCacheUtil, String marketUrl, String title, String tradeUrl) {
		this.redisCacheUtil = redisCacheUtil;
		this.marketUrl = marketUrl;
		this.title = title;
		this.tradeUrl = tradeUrl;
	}

	@Override
	public void run() {

		log.info("【限价单交易请求】线程启动...");

		Context context = ZMQ.context(1);
		Socket subscriber = context.socket(ZMQ.SUB);
		subscriber.connect(marketUrl);
		subscriber.subscribe(title.getBytes());

		while (true) {
			String msg = subscriber.recvStr();
			String message = msg.substring(msg.lastIndexOf("{"));

			if (null == message)
				continue;

			JSONObject obj = JSONObject.parseObject(message);
			RealTimeMarketdata marketdata = obj.toJavaObject(RealTimeMarketdata.class);

			String queueName = genLimitOrderQueueName(marketdata.getStockcode(), marketdata.getNow());
			// 该限价单队列有订单存在
			while (redisCacheUtil.getCacheListSize(queueName) > 0) {
				Order order = redisCacheUtil.popCacheList(queueName);
				try {
					if (order.getOrderPrice().compareTo(marketdata.getNow()) != 0) {
						redisCacheUtil.pushCacheList(queueName, order);
					} else {
						BigDecimal cost = order.getOrderPrice().multiply(order.getOrderHand());
						BigDecimal serv = cost.multiply(BigDecimal.valueOf(0.001));

						order.setOrderAmount(cost);
						order.setServiceAmount(serv);

						// 调用trade接口
						String returnStr = HttpClientUtils.doPost(tradeUrl, JSON.toJSONString(order));
						if (null != returnStr) {
							log.info("【限价单交易请求】returnStr：" + returnStr);

							try {
								Response resp = JSON.parseObject(returnStr, Response.class);
								if (!resp.get_ReturnCode().equals(StatusCode.SUCCESS.getCode())) {
									log.info("【限价单交易请求】交易失败，order：" + JSON.toJSONString(order));
								} else {
									log.info("【限价单交易请求】交易成功，order：" + JSON.toJSONString(order));
								}
							} catch (Exception e) {
								log.info("【限价单交易请求】请求失败，重新进入限价单队列，order：" + JSON.toJSONString(order));
								redisCacheUtil.pushCacheList(queueName, order);
							}

						} else {
							log.info("【限价单交易请求】请求失败，重新进入限价单队列，order：" + JSON.toJSONString(order));
							redisCacheUtil.pushCacheList(queueName, order);
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					log.info("【限价单交易请求】出现异常，重新进入限价单队列，order：" + JSON.toJSONString(order));
					redisCacheUtil.pushCacheList(queueName, order);
				}
			}
		}
	}

	public String genLimitOrderQueueName(String stockcode, BigDecimal orderPrice) {
		return OrderQueueName.LIMIT_ORDER_QUEUE.name() + ":" + stockcode + "-" + orderPrice;
	}
}
