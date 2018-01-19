package com.szw.trading.trade;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TradeApplication {
	private final Logger log = Logger.getLogger(TradeApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(TradeApplication.class, args);
	}
}
