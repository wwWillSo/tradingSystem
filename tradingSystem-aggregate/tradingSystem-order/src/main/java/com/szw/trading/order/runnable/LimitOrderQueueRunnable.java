package com.szw.trading.order.runnable;

import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import com.szw.trading.persistence.entity.Order;
import com.szw.util.RedisCacheUtil;


public class LimitOrderQueueRunnable implements Callable<LimitOrderQueueRunnable> {

	private final Logger log = Logger.getLogger(LimitOrderQueueRunnable.class);

	private RedisCacheUtil<Order> redisCacheUtil;

	private String getMarketDataByCodeUrl;

	private String tradeUrl;

	public LimitOrderQueueRunnable(RedisCacheUtil<Order> redisCacheUtil, String getMarketDataByCodeUrl, String tradeUrl) {
		this.redisCacheUtil = redisCacheUtil;
		this.getMarketDataByCodeUrl = getMarketDataByCodeUrl;
		this.tradeUrl = tradeUrl;
	}

	@Override
	public LimitOrderQueueRunnable call() throws Exception {

		while (true) {

		}
	}
}
