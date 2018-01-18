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
 * The persistent class for the customer_trading_account database table.
 * 
 */
@Entity
@Table(name = "customer_trading_account")
@NamedQuery(name = "CustomerTradingAccount.findAll", query = "SELECT c FROM CustomerTradingAccount c")
public class CustomerTradingAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trading_account_id")
	private BigInteger tradingAccountId;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "deposit_amount")
	private BigDecimal depositAmount;

	@Column(name = "usable_amount")
	private BigDecimal usableAmount;

	public CustomerTradingAccount() {
	}

	public BigInteger getTradingAccountId() {
		return tradingAccountId;
	}

	public void setTradingAccountId(BigInteger tradingAccountId) {
		this.tradingAccountId = tradingAccountId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public BigDecimal getDepositAmount() {
		return this.depositAmount;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public BigDecimal getUsableAmount() {
		return this.usableAmount;
	}

	public void setUsableAmount(BigDecimal usableAmount) {
		this.usableAmount = usableAmount;
	}

}