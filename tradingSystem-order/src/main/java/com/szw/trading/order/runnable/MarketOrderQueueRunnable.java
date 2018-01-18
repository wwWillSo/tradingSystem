package com.szw.trading.order.runnable;

import java.util.concurrent.Callable;

import com.szw.trading.persistence.entity.Order;
import com.szw.util.RedisCacheUtil;


public class MarketOrderQueueRunnable implements Callable<MarketOrderQueueRunnable> {

	private RedisCacheUtil<Order> redisCacheUtil;

	public MarketOrderQueueRunnable(RedisCacheUtil<Order> redisCacheUtil) {
		this.redisCacheUtil = redisCacheUtil;
	}

	@Override
	public MarketOrderQueueRunnable call() throws Exception {
		while (true) {
			// Order marketOrder = redisCacheUtil.popCacheList(OrderQueue.MARKET_ORDER_QUEUE);
		}
	}

}
