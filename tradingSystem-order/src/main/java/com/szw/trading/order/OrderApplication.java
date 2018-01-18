package com.szw.trading.order;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OrderApplication {
	private final Logger log = Logger.getLogger(OrderApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(OrderApplication.class, args);
	}
}
