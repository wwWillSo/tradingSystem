package com.szw.trading.mybatis.entity;

import java.math.BigDecimal;

public class InvestmentSummary {
    private Long investmentId;

    private Long tradingAccountId;

    private String stockCode;

    private BigDecimal deposit;

    private BigDecimal hand;

    private BigDecimal floatingWinloss;

    public Long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Long investmentId) {
        this.investmentId = investmentId;
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

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getHand() {
        return hand;
    }

    public void setHand(BigDecimal hand) {
        this.hand = hand;
    }

    public BigDecimal getFloatingWinloss() {
        return floatingWinloss;
    }

    public void setFloatingWinloss(BigDecimal floatingWinloss) {
        this.floatingWinloss = floatingWinloss;
    }
}