package com.szw.trading.mybatis.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LoginExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public LoginExample() {
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

		public Criteria andLoginIdIsNull() {
			addCriterion("login_id is null");
			return (Criteria) this;
		}

		public Criteria andLoginIdIsNotNull() {
			addCriterion("login_id is not null");
			return (Criteria) this;
		}

		public Criteria andLoginIdEqualTo(Integer value) {
			addCriterion("login_id =", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotEqualTo(Integer value) {
			addCriterion("login_id <>", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdGreaterThan(Integer value) {
			addCriterion("login_id >", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("login_id >=", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLessThan(Integer value) {
			addCriterion("login_id <", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdLessThanOrEqualTo(Integer value) {
			addCriterion("login_id <=", value, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdIn(List<Integer> values) {
			addCriterion("login_id in", values, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotIn(List<Integer> values) {
			addCriterion("login_id not in", values, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdBetween(Integer value1, Integer value2) {
			addCriterion("login_id between", value1, value2, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginIdNotBetween(Integer value1, Integer value2) {
			addCriterion("login_id not between", value1, value2, "loginId");
			return (Criteria) this;
		}

		public Criteria andLoginNameIsNull() {
			addCriterion("login_name is null");
			return (Criteria) this;
		}

		public Criteria andLoginNameIsNotNull() {
			addCriterion("login_name is not null");
			return (Criteria) this;
		}

		public Criteria andLoginNameEqualTo(String value) {
			addCriterion("login_name =", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotEqualTo(String value) {
			addCriterion("login_name <>", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameGreaterThan(String value) {
			addCriterion("login_name >", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameGreaterThanOrEqualTo(String value) {
			addCriterion("login_name >=", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameLessThan(String value) {
			addCriterion("login_name <", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameLessThanOrEqualTo(String value) {
			addCriterion("login_name <=", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameLike(String value) {
			addCriterion("login_name like", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotLike(String value) {
			addCriterion("login_name not like", value, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameIn(List<String> values) {
			addCriterion("login_name in", values, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotIn(List<String> values) {
			addCriterion("login_name not in", values, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameBetween(String value1, String value2) {
			addCriterion("login_name between", value1, value2, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginNameNotBetween(String value1, String value2) {
			addCriterion("login_name not between", value1, value2, "loginName");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordIsNull() {
			addCriterion("login_password is null");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordIsNotNull() {
			addCriterion("login_password is not null");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordEqualTo(String value) {
			addCriterion("login_password =", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotEqualTo(String value) {
			addCriterion("login_password <>", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordGreaterThan(String value) {
			addCriterion("login_password >", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("login_password >=", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordLessThan(String value) {
			addCriterion("login_password <", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordLessThanOrEqualTo(String value) {
			addCriterion("login_password <=", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordLike(String value) {
			addCriterion("login_password like", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotLike(String value) {
			addCriterion("login_password not like", value, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordIn(List<String> values) {
			addCriterion("login_password in", values, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotIn(List<String> values) {
			addCriterion("login_password not in", values, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordBetween(String value1, String value2) {
			addCriterion("login_password between", value1, value2, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginPasswordNotBetween(String value1, String value2) {
			addCriterion("login_password not between", value1, value2, "loginPassword");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusIsNull() {
			addCriterion("login_account_status is null");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusIsNotNull() {
			addCriterion("login_account_status is not null");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusEqualTo(Integer value) {
			addCriterion("login_account_status =", value, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusNotEqualTo(Integer value) {
			addCriterion("login_account_status <>", value, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusGreaterThan(Integer value) {
			addCriterion("login_account_status >", value, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("login_account_status >=", value, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusLessThan(Integer value) {
			addCriterion("login_account_status <", value, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusLessThanOrEqualTo(Integer value) {
			addCriterion("login_account_status <=", value, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusIn(List<Integer> values) {
			addCriterion("login_account_status in", values, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusNotIn(List<Integer> values) {
			addCriterion("login_account_status not in", values, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusBetween(Integer value1, Integer value2) {
			addCriterion("login_account_status between", value1, value2, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andLoginAccountStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("login_account_status not between", value1, value2, "loginAccountStatus");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNull() {
			addCriterion("customer_id is null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIsNotNull() {
			addCriterion("customer_id is not null");
			return (Criteria) this;
		}

		public Criteria andCustomerIdEqualTo(Integer value) {
			addCriterion("customer_id =", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotEqualTo(Integer value) {
			addCriterion("customer_id <>", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThan(Integer value) {
			addCriterion("customer_id >", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("customer_id >=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThan(Integer value) {
			addCriterion("customer_id <", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdLessThanOrEqualTo(Integer value) {
			addCriterion("customer_id <=", value, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdIn(List<Integer> values) {
			addCriterion("customer_id in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotIn(List<Integer> values) {
			addCriterion("customer_id not in", values, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdBetween(Integer value1, Integer value2) {
			addCriterion("customer_id between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andCustomerIdNotBetween(Integer value1, Integer value2) {
			addCriterion("customer_id not between", value1, value2, "customerId");
			return (Criteria) this;
		}

		public Criteria andAdminIsNull() {
			addCriterion("admin is null");
			return (Criteria) this;
		}

		public Criteria andAdminIsNotNull() {
			addCriterion("admin is not null");
			return (Criteria) this;
		}

		public Criteria andAdminEqualTo(Boolean value) {
			addCriterion("admin =", value, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminNotEqualTo(Boolean value) {
			addCriterion("admin <>", value, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminGreaterThan(Boolean value) {
			addCriterion("admin >", value, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminGreaterThanOrEqualTo(Boolean value) {
			addCriterion("admin >=", value, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminLessThan(Boolean value) {
			addCriterion("admin <", value, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminLessThanOrEqualTo(Boolean value) {
			addCriterion("admin <=", value, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminIn(List<Boolean> values) {
			addCriterion("admin in", values, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminNotIn(List<Boolean> values) {
			addCriterion("admin not in", values, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminBetween(Boolean value1, Boolean value2) {
			addCriterion("admin between", value1, value2, "admin");
			return (Criteria) this;
		}

		public Criteria andAdminNotBetween(Boolean value1, Boolean value2) {
			addCriterion("admin not between", value1, value2, "admin");
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

		public Criteria andAgentIdIsNull() {
			addCriterion("agent_id is null");
			return (Criteria) this;
		}

		public Criteria andAgentIdIsNotNull() {
			addCriterion("agent_id is not null");
			return (Criteria) this;
		}

		public Criteria andAgentIdEqualTo(Integer value) {
			addCriterion("agent_id =", value, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdNotEqualTo(Integer value) {
			addCriterion("agent_id <>", value, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdGreaterThan(Integer value) {
			addCriterion("agent_id >", value, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("agent_id >=", value, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdLessThan(Integer value) {
			addCriterion("agent_id <", value, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdLessThanOrEqualTo(Integer value) {
			addCriterion("agent_id <=", value, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdIn(List<Integer> values) {
			addCriterion("agent_id in", values, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdNotIn(List<Integer> values) {
			addCriterion("agent_id not in", values, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdBetween(Integer value1, Integer value2) {
			addCriterion("agent_id between", value1, value2, "agentId");
			return (Criteria) this;
		}

		public Criteria andAgentIdNotBetween(Integer value1, Integer value2) {
			addCriterion("agent_id not between", value1, value2, "agentId");
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