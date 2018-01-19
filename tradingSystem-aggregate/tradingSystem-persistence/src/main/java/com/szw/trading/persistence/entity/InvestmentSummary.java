package com.szw.trading.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the investment_summary database table.
 * 
 */
@Entity
@Table(name = "investment_summary")
@NamedQuery(name = "InvestmentSummary.findAll", query = "SELECT i FROM InvestmentSummary i")
public class InvestmentSummary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "investment_id")
	private BigInteger investmentId;

	private BigDecimal deposit;

	@Column(name = "floating_winloss")
	private BigDecimal floatingWinloss;

	private BigDecimal hand;

	@Column(name = "stock_code")
	private String stockCode;

	@Column(name = "trading_account_id")
	private BigInteger tradingAccountId;

	public InvestmentSummary() {
	}

	public BigInteger getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(BigInteger investmentId) {
		this.investmentId = investmentId;
	}

	public BigDecimal getDeposit() {
		return this.deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public BigDecimal getFloatingWinloss() {
		return this.floatingWinloss;
	}

	public void setFloatingWinloss(BigDecimal floatingWinloss) {
		this.floatingWinloss = floatingWinloss;
	}

	public BigDecimal getHand() {
		return this.hand;
	}

	public void setHand(BigDecimal hand) {
		this.hand = hand;
	}

	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public BigInteger getTradingAccountId() {
		return this.tradingAccountId;
	}

	public void setTradingAccountId(BigInteger tradingAccountId) {
		this.tradingAccountId = tradingAccountId;
	}

}