package com.szw.trading.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.CustomerTradingAccount;


@Repository("customerTradingAccountRepository")
public interface CustomerTradingAccountRepository extends JpaRepository<CustomerTradingAccount, BigInteger> {

	public CustomerTradingAccount findByCustomerId(Integer customerId);
}
