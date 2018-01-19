package com.szw.trading.persistence.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.szw.trading.persistence.entity.InvestmentSummary;


@Repository("investmentSummary")
public interface InvestmentSummaryRepository extends JpaRepository<InvestmentSummary, BigInteger> {

}
