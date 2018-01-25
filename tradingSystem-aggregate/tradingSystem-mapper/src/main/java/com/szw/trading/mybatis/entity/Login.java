package com.szw.trading.mybatis.entity;

import java.util.Date;


public class Login {
	private Integer loginId;

	private String loginName;

	private String loginPassword;

	private Integer loginAccountStatus;

	private Integer customerId;

	private Boolean admin;

	private Date createTime;

	private Integer agentId;

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword == null ? null : loginPassword.trim();
	}

	public Integer getLoginAccountStatus() {
		return loginAccountStatus;
	}

	public void setLoginAccountStatus(Integer loginAccountStatus) {
		this.loginAccountStatus = loginAccountStatus;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
}