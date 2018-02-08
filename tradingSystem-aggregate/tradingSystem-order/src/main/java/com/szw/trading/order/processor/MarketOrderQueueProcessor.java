package com.szw.trading.order.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.szw.trading.order.runnable.MarketOrderQueueRunnable;
import com.szw.trading.persistence.entity.Order;
import com.szw.util.RedisCacheUtil;


/**
 * 创建线程，监控redis市价单队列,提交到交易模块
 * 
 * @author 苏镇威 2018年1月18日 下午5:47:22
 */
@Deprecated
@Service
public class MarketOrderQueueProcessor {

	private ExecutorService threadPool = Executors.newSingleThreadExecutor();

	@Autowired
	private RedisCacheUtil<Order> redisCacheUtil;

	@Value("${getMarketDataByCode.url}")
	private String getMarketDataByCodeUrl;

	@Value("${trade.url}")
	private String tradeUrl;

	public void execute() {
		try {
			threadPool.submit(new MarketOrderQueueRunnable(redisCacheUtil, getMarketDataByCodeUrl, tradeUrl));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
