package com.szw.trading.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the login database table.
 * 
 */
@Entity
@NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "login_id")
	private Integer loginId;

	private byte admin;

	@Column(name = "agent_id")
	private int agentId;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "login_account_status")
	private int loginAccountStatus;

	@Column(name = "login_name")
	private String loginName;

	@Column(name = "login_password")
	private String loginPassword;

	public Login() {
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public byte getAdmin() {
		return this.admin;
	}

	public void setAdmin(byte admin) {
		this.admin = admin;
	}

	public int getAgentId() {
		return this.agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLoginAccountStatus() {
		return this.loginAccountStatus;
	}

	public void setLoginAccountStatus(int loginAccountStatus) {
		this.loginAccountStatus = loginAccountStatus;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

}