package com.szw.trading.order;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szw.trading.order.processor.TradingSystemThreadPoolExecutor;
import com.szw.trading.order.runnable.LimitOrderQueueRunnable;
import com.szw.trading.order.runnable.MarketOrderQueueRunnable;
import com.szw.trading.persistence.entity.Order;
import com.szw.util.RedisCacheUtil;


@SpringBootApplication
public class OrderApplication {
	private final Logger log = Logger.getLogger(OrderApplication.class);

	@Autowired
	private RedisCacheUtil<Order> redisCacheUtil;
	@Value("${getMarketDataByCode.url}")
	private String getMarketDataByCodeUrl;
	@Value("${trade.url}")
	private String tradeUrl;
	@Value("${market.url}")
	private String marketUrl;
	private String title = "marketdata";

	@Autowired
	private TradingSystemThreadPoolExecutor threadPoolExecutor;

	@PostConstruct
	public void init() {
		threadPoolExecutor.init();
		threadPoolExecutor.addTask(new LimitOrderQueueRunnable(redisCacheUtil, marketUrl, title, tradeUrl));
		threadPoolExecutor.addTask(new MarketOrderQueueRunnable(redisCacheUtil, getMarketDataByCodeUrl, tradeUrl));
	}

	public static void main(String[] args) {

		SpringApplication.run(OrderApplication.class, args);
	}
}
