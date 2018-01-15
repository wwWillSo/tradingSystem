package com.szw.trading;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TradingSystemApplication {

	private final Logger log = Logger.getLogger(TradingSystemApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(TradingSystemApplication.class, args);
	}
}
