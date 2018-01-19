package com.szw.trading.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.InvestmentSummary;


@Repository
public interface InvestmentSummaryRepository extends JpaRepository<InvestmentSummary, BigInteger> {

	public InvestmentSummary findByTradingAccountIdAndStockCode(BigInteger tradingAccountId, String stockCode);
}
