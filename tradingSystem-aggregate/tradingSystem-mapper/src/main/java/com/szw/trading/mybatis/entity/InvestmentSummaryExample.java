package com.szw.trading.mybatis.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvestmentSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvestmentSummaryExample() {
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

        public Criteria andInvestmentIdIsNull() {
            addCriterion("investment_id is null");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdIsNotNull() {
            addCriterion("investment_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdEqualTo(Long value) {
            addCriterion("investment_id =", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotEqualTo(Long value) {
            addCriterion("investment_id <>", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdGreaterThan(Long value) {
            addCriterion("investment_id >", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("investment_id >=", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdLessThan(Long value) {
            addCriterion("investment_id <", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdLessThanOrEqualTo(Long value) {
            addCriterion("investment_id <=", value, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdIn(List<Long> values) {
            addCriterion("investment_id in", values, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotIn(List<Long> values) {
            addCriterion("investment_id not in", values, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdBetween(Long value1, Long value2) {
            addCriterion("investment_id between", value1, value2, "investmentId");
            return (Criteria) this;
        }

        public Criteria andInvestmentIdNotBetween(Long value1, Long value2) {
            addCriterion("investment_id not between", value1, value2, "investmentId");
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

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andHandIsNull() {
            addCriterion("hand is null");
            return (Criteria) this;
        }

        public Criteria andHandIsNotNull() {
            addCriterion("hand is not null");
            return (Criteria) this;
        }

        public Criteria andHandEqualTo(BigDecimal value) {
            addCriterion("hand =", value, "hand");
            return (Criteria) this;
        }

        public Criteria andHandNotEqualTo(BigDecimal value) {
            addCriterion("hand <>", value, "hand");
            return (Criteria) this;
        }

        public Criteria andHandGreaterThan(BigDecimal value) {
            addCriterion("hand >", value, "hand");
            return (Criteria) this;
        }

        public Criteria andHandGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hand >=", value, "hand");
            return (Criteria) this;
        }

        public Criteria andHandLessThan(BigDecimal value) {
            addCriterion("hand <", value, "hand");
            return (Criteria) this;
        }

        public Criteria andHandLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hand <=", value, "hand");
            return (Criteria) this;
        }

        public Criteria andHandIn(List<BigDecimal> values) {
            addCriterion("hand in", values, "hand");
            return (Criteria) this;
        }

        public Criteria andHandNotIn(List<BigDecimal> values) {
            addCriterion("hand not in", values, "hand");
            return (Criteria) this;
        }

        public Criteria andHandBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hand between", value1, value2, "hand");
            return (Criteria) this;
        }

        public Criteria andHandNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hand not between", value1, value2, "hand");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossIsNull() {
            addCriterion("floating_winloss is null");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossIsNotNull() {
            addCriterion("floating_winloss is not null");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossEqualTo(BigDecimal value) {
            addCriterion("floating_winloss =", value, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossNotEqualTo(BigDecimal value) {
            addCriterion("floating_winloss <>", value, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossGreaterThan(BigDecimal value) {
            addCriterion("floating_winloss >", value, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("floating_winloss >=", value, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossLessThan(BigDecimal value) {
            addCriterion("floating_winloss <", value, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossLessThanOrEqualTo(BigDecimal value) {
            addCriterion("floating_winloss <=", value, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossIn(List<BigDecimal> values) {
            addCriterion("floating_winloss in", values, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossNotIn(List<BigDecimal> values) {
            addCriterion("floating_winloss not in", values, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floating_winloss between", value1, value2, "floatingWinloss");
            return (Criteria) this;
        }

        public Criteria andFloatingWinlossNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floating_winloss not between", value1, value2, "floatingWinloss");
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