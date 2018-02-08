package com.szw.trading.order.processor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.szw.trading.order.runnable.LimitOrderQueueRunnable;
import com.szw.trading.persistence.entity.Order;
import com.szw.util.RedisCacheUtil;


/**
 * 创建线程，监控redis限价单队列,提交到交易模块
 * 
 * @author 苏镇威 2018年1月26日 下午4:34:13
 */
@Deprecated
@Service
public class LimitOrderQueueProcessor {

	private ExecutorService threadPool = Executors.newSingleThreadExecutor();

	@Autowired
	private RedisCacheUtil<Order> redisCacheUtil;

	@Value("${trade.url}")
	private String tradeUrl;

	@Value("${market.url}")
	private String marketUrl;

	private String title = "marketdata";

	public void execute() {
		try {
			threadPool.submit(new LimitOrderQueueRunnable(redisCacheUtil, marketUrl, title, tradeUrl));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
