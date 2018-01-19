package com.szw.trading.order;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szw.trading.order.processor.MarketOrderQueueProcessor;


@SpringBootApplication
public class OrderApplication {
	private final Logger log = Logger.getLogger(OrderApplication.class);

	@Autowired
	private MarketOrderQueueProcessor marketOrderQueueProcessor;

	@PostConstruct
	public void init() {
		marketOrderQueueProcessor.execute();
	}

	public static void main(String[] args) {

		SpringApplication.run(OrderApplication.class, args);
	}
}
