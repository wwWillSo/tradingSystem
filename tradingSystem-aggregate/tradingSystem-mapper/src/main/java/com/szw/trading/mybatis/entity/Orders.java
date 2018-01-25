package com.szw.trading.mybatis.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Long orderId;

    private Long tradingAccountId;

    private String stockCode;

    private String orderNo;

    private BigDecimal orderAmount;

    private BigDecimal orderPrice;

    private BigDecimal serviceAmount;

    private BigDecimal orderHand;

    private Integer orderSide;

    private Integer orderType;

    private String offsetOrderNo;

    private Integer offsetted;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private BigDecimal winLoss;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTradingAccountId() {
        return tradingAccountId;
    }

    public void setTradingAccountId(Long tradingAccountId) {
        this.tradingAccountId = tradingAccountId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode == null ? null : stockCode.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public BigDecimal getOrderHand() {
        return orderHand;
    }

    public void setOrderHand(BigDecimal orderHand) {
        this.orderHand = orderHand;
    }

    public Integer getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(Integer orderSide) {
        this.orderSide = orderSide;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getOffsetOrderNo() {
        return offsetOrderNo;
    }

    public void setOffsetOrderNo(String offsetOrderNo) {
        this.offsetOrderNo = offsetOrderNo == null ? null : offsetOrderNo.trim();
    }

    public Integer getOffsetted() {
        return offsetted;
    }

    public void setOffsetted(Integer offsetted) {
        this.offsetted = offsetted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getWinLoss() {
        return winLoss;
    }

    public void setWinLoss(BigDecimal winLoss) {
        this.winLoss = winLoss;
    }
}