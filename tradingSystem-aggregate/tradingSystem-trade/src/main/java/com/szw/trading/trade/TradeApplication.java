package com.szw.trading.trade;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.szw.trading.persistence.repository.LoginRepository;


@SpringBootApplication
public class TradeApplication {
	private final Logger log = Logger.getLogger(TradeApplication.class);

	@Autowired
	private LoginRepository loginRepository;

	@PostConstruct
	public void init() {
		log.info("loginRepository:" + loginRepository);
		log.info("loginRepository.count:" + loginRepository.count());
	}

	public static void main(String[] args) {

		SpringApplication.run(TradeApplication.class, args);
	}
}
