package com.szw.trading.order.processor;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TradingSystemThreadPoolExecutor {

	private final Logger log = Logger.getLogger(getClass());

	@Value("${tradingSystem.corePoolSize}")
	private String corePoolSize;
	@Value("${tradingSystem.maximumPoolSize}")
	private String maximumPoolSize;
	@Value("${tradingSystem.keepAliveTime}")
	private String keepAliveTime;
	@Value("${tradingSystem.queueSize}")
	private String queueSize;

	private ThreadPoolExecutor threadPool;

	public TradingSystemThreadPoolExecutor() {
		super();
	}

	public void init() {
		threadPool = new ThreadPoolExecutor(Integer.valueOf(corePoolSize), Integer.valueOf(maximumPoolSize), Integer.valueOf(keepAliveTime),
				TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(Integer.valueOf(queueSize)));
	}

	public void addTask(Runnable task) {
		threadPool.execute(task);
	}
}
