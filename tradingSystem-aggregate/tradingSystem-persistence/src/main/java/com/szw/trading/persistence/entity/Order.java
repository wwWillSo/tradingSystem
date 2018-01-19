package com.szw.trading.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name = "`order`")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private BigInteger orderId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "order_amount")
	private BigDecimal orderAmount;

	@Column(name = "order_hand")
	private BigDecimal orderHand;

	@Column(name = "order_no")
	private String orderNo;

	@Column(name = "order_price")
	private BigDecimal orderPrice;

	@Column(name = "order_side")
	private int orderSide;

	@Column(name = "order_type")
	private int orderType;

	@Column(name = "service_amount")
	private BigDecimal serviceAmount;

	private int status;

	private int offsetted;

	@Column(name = "offset_order_no")
	private String offsetOrderNo;

	@Column(name = "stock_code")
	private String stockCode;

	@Column(name = "trading_account_id")
	private BigInteger tradingAccountId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "win_loss")
	private BigDecimal winLoss;

	public Order() {
	}

	public BigDecimal getWinLoss() {
		return winLoss;
	}

	public void setWinLoss(BigDecimal winLoss) {
		this.winLoss = winLoss;
	}

	public String getOffsetOrderNo() {
		return offsetOrderNo;
	}

	public void setOffsetOrderNo(String offsetOrderNo) {
		this.offsetOrderNo = offsetOrderNo;
	}

	public int getOffsetted() {
		return offsetted;
	}

	public void setOffsetted(int offsetted) {
		this.offsetted = offsetted;
	}

	public BigInteger getOrderId() {
		return orderId;
	}

	public void setOrderId(BigInteger orderId) {
		this.orderId = orderId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getOrderHand() {
		return this.orderHand;
	}

	public void setOrderHand(BigDecimal orderHand) {
		this.orderHand = orderHand;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderSide() {
		return this.orderSide;
	}

	public void setOrderSide(int orderSide) {
		this.orderSide = orderSide;
	}

	public int getOrderType() {
		return this.orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getServiceAmount() {
		return this.serviceAmount;
	}

	public void setServiceAmount(BigDecimal serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}