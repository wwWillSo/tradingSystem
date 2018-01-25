package com.szw.trading.mybatis.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdIsNull() {
            addCriterion("trading_account_id is null");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdIsNotNull() {
            addCriterion("trading_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdEqualTo(Long value) {
            addCriterion("trading_account_id =", value, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdNotEqualTo(Long value) {
            addCriterion("trading_account_id <>", value, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdGreaterThan(Long value) {
            addCriterion("trading_account_id >", value, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trading_account_id >=", value, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdLessThan(Long value) {
            addCriterion("trading_account_id <", value, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdLessThanOrEqualTo(Long value) {
            addCriterion("trading_account_id <=", value, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdIn(List<Long> values) {
            addCriterion("trading_account_id in", values, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdNotIn(List<Long> values) {
            addCriterion("trading_account_id not in", values, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdBetween(Long value1, Long value2) {
            addCriterion("trading_account_id between", value1, value2, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andTradingAccountIdNotBetween(Long value1, Long value2) {
            addCriterion("trading_account_id not between", value1, value2, "tradingAccountId");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNull() {
            addCriterion("stock_code is null");
            return (Criteria) this;
        }

        public Criteria andStockCodeIsNotNull() {
            addCriterion("stock_code is not null");
            return (Criteria) this;
        }

        public Criteria andStockCodeEqualTo(String value) {
            addCriterion("stock_code =", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotEqualTo(String value) {
            addCriterion("stock_code <>", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThan(String value) {
            addCriterion("stock_code >", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeGreaterThanOrEqualTo(String value) {
            addCriterion("stock_code >=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThan(String value) {
            addCriterion("stock_code <", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLessThanOrEqualTo(String value) {
            addCriterion("stock_code <=", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeLike(String value) {
            addCriterion("stock_code like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotLike(String value) {
            addCriterion("stock_code not like", value, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeIn(List<String> values) {
            addCriterion("stock_code in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotIn(List<String> values) {
            addCriterion("stock_code not in", values, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeBetween(String value1, String value2) {
            addCriterion("stock_code between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andStockCodeNotBetween(String value1, String value2) {
            addCriterion("stock_code not between", value1, value2, "stockCode");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNull() {
            addCriterion("order_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIsNotNull() {
            addCriterion("order_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceEqualTo(BigDecimal value) {
            addCriterion("order_price =", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_price <>", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("order_price >", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price >=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThan(BigDecimal value) {
            addCriterion("order_price <", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_price <=", value, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceIn(List<BigDecimal> values) {
            addCriterion("order_price in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_price not in", values, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_price not between", value1, value2, "orderPrice");
            return (Criteria) this;
        }

        public Criteria andServiceAmountIsNull() {
            addCriterion("service_amount is null");
            return (Criteria) this;
        }

        public Criteria andServiceAmountIsNotNull() {
            addCriterion("service_amount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceAmountEqualTo(BigDecimal value) {
            addCriterion("service_amount =", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountNotEqualTo(BigDecimal value) {
            addCriterion("service_amount <>", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountGreaterThan(BigDecimal value) {
            addCriterion("service_amount >", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_amount >=", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountLessThan(BigDecimal value) {
            addCriterion("service_amount <", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_amount <=", value, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountIn(List<BigDecimal> values) {
            addCriterion("service_amount in", values, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountNotIn(List<BigDecimal> values) {
            addCriterion("service_amount not in", values, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_amount between", value1, value2, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andServiceAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_amount not between", value1, value2, "serviceAmount");
            return (Criteria) this;
        }

        public Criteria andOrderHandIsNull() {
            addCriterion("order_hand is null");
            return (Criteria) this;
        }

        public Criteria andOrderHandIsNotNull() {
            addCriterion("order_hand is not null");
            return (Criteria) this;
        }

        public Criteria andOrderHandEqualTo(BigDecimal value) {
            addCriterion("order_hand =", value, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandNotEqualTo(BigDecimal value) {
            addCriterion("order_hand <>", value, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandGreaterThan(BigDecimal value) {
            addCriterion("order_hand >", value, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_hand >=", value, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandLessThan(BigDecimal value) {
            addCriterion("order_hand <", value, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_hand <=", value, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandIn(List<BigDecimal> values) {
            addCriterion("order_hand in", values, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandNotIn(List<BigDecimal> values) {
            addCriterion("order_hand not in", values, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_hand between", value1, value2, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderHandNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_hand not between", value1, value2, "orderHand");
            return (Criteria) this;
        }

        public Criteria andOrderSideIsNull() {
            addCriterion("order_side is null");
            return (Criteria) this;
        }

        public Criteria andOrderSideIsNotNull() {
            addCriterion("order_side is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSideEqualTo(Integer value) {
            addCriterion("order_side =", value, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideNotEqualTo(Integer value) {
            addCriterion("order_side <>", value, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideGreaterThan(Integer value) {
            addCriterion("order_side >", value, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_side >=", value, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideLessThan(Integer value) {
            addCriterion("order_side <", value, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideLessThanOrEqualTo(Integer value) {
            addCriterion("order_side <=", value, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideIn(List<Integer> values) {
            addCriterion("order_side in", values, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideNotIn(List<Integer> values) {
            addCriterion("order_side not in", values, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideBetween(Integer value1, Integer value2) {
            addCriterion("order_side between", value1, value2, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderSideNotBetween(Integer value1, Integer value2) {
            addCriterion("order_side not between", value1, value2, "orderSide");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Integer value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Integer value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Integer value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Integer value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Integer> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Integer> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoIsNull() {
            addCriterion("offset_order_no is null");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoIsNotNull() {
            addCriterion("offset_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoEqualTo(String value) {
            addCriterion("offset_order_no =", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoNotEqualTo(String value) {
            addCriterion("offset_order_no <>", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoGreaterThan(String value) {
            addCriterion("offset_order_no >", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("offset_order_no >=", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoLessThan(String value) {
            addCriterion("offset_order_no <", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoLessThanOrEqualTo(String value) {
            addCriterion("offset_order_no <=", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoLike(String value) {
            addCriterion("offset_order_no like", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoNotLike(String value) {
            addCriterion("offset_order_no not like", value, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoIn(List<String> values) {
            addCriterion("offset_order_no in", values, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoNotIn(List<String> values) {
            addCriterion("offset_order_no not in", values, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoBetween(String value1, String value2) {
            addCriterion("offset_order_no between", value1, value2, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsetOrderNoNotBetween(String value1, String value2) {
            addCriterion("offset_order_no not between", value1, value2, "offsetOrderNo");
            return (Criteria) this;
        }

        public Criteria andOffsettedIsNull() {
            addCriterion("offsetted is null");
            return (Criteria) this;
        }

        public Criteria andOffsettedIsNotNull() {
            addCriterion("offsetted is not null");
            return (Criteria) this;
        }

        public Criteria andOffsettedEqualTo(Integer value) {
            addCriterion("offsetted =", value, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedNotEqualTo(Integer value) {
            addCriterion("offsetted <>", value, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedGreaterThan(Integer value) {
            addCriterion("offsetted >", value, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedGreaterThanOrEqualTo(Integer value) {
            addCriterion("offsetted >=", value, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedLessThan(Integer value) {
            addCriterion("offsetted <", value, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedLessThanOrEqualTo(Integer value) {
            addCriterion("offsetted <=", value, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedIn(List<Integer> values) {
            addCriterion("offsetted in", values, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedNotIn(List<Integer> values) {
            addCriterion("offsetted not in", values, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedBetween(Integer value1, Integer value2) {
            addCriterion("offsetted between", value1, value2, "offsetted");
            return (Criteria) this;
        }

        public Criteria andOffsettedNotBetween(Integer value1, Integer value2) {
            addCriterion("offsetted not between", value1, value2, "offsetted");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andWinLossIsNull() {
            addCriterion("win_loss is null");
            return (Criteria) this;
        }

        public Criteria andWinLossIsNotNull() {
            addCriterion("win_loss is not null");
            return (Criteria) this;
        }

        public Criteria andWinLossEqualTo(BigDecimal value) {
            addCriterion("win_loss =", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossNotEqualTo(BigDecimal value) {
            addCriterion("win_loss <>", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossGreaterThan(BigDecimal value) {
            addCriterion("win_loss >", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("win_loss >=", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossLessThan(BigDecimal value) {
            addCriterion("win_loss <", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossLessThanOrEqualTo(BigDecimal value) {
            addCriterion("win_loss <=", value, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossIn(List<BigDecimal> values) {
            addCriterion("win_loss in", values, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossNotIn(List<BigDecimal> values) {
            addCriterion("win_loss not in", values, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("win_loss between", value1, value2, "winLoss");
            return (Criteria) this;
        }

        public Criteria andWinLossNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("win_loss not between", value1, value2, "winLoss");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}