package com.szw.trading.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name = "customers")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int customerId;

	@Column(name = "customer_bank_account_id")
	private String customerBankAccountId;

	@Column(name = "customer_bank_account_name")
	private String customerBankAccountName;

	@Column(name = "customer_bank_name")
	private String customerBankName;

	@Temporal(TemporalType.DATE)
	@Column(name = "customer_birth_date")
	private Date customerBirthDate;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_identity_document_id")
	private String customerIdentityDocumentId;

	@Column(name = "customer_identity_document_type")
	private int customerIdentityDocumentType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "customer_join_date")
	private Date customerJoinDate;

	@Column(name = "customer_mobile")
	private String customerMobile;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_password")
	private String customerPassword;

	@Column(name = "customer_qq_num")
	private String customerQqNum;

	@Column(name = "customer_status")
	private int customerStatus;

	@Column(name = "customer_stu_card_id")
	private String customerStuCardId;

	@Column(name = "customer_wechat_id")
	private String customerWechatId;

	@Column(name = "customer_portrait")
	private String customerPortrait;

	@Column(name = "identity_varify_status")
	private int identityVarifyStatus;

	@Column(name = "depart_id")
	private BigInteger departId;

	public Customer() {
	}

	public BigInteger getDepartId() {
		return departId;
	}

	public void setDepartId(BigInteger departId) {
		this.departId = departId;
	}

	public String getCustomerPortrait() {
		return customerPortrait;
	}

	public void setCustomerPortrait(String customerPortrait) {
		this.customerPortrait = customerPortrait;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerBankAccountId() {
		return this.customerBankAccountId;
	}

	public void setCustomerBankAccountId(String customerBankAccountId) {
		this.customerBankAccountId = customerBankAccountId;
	}

	public String getCustomerBankAccountName() {
		return this.customerBankAccountName;
	}

	public void setCustomerBankAccountName(String customerBankAccountName) {
		this.customerBankAccountName = customerBankAccountName;
	}

	public String getCustomerBankName() {
		return this.customerBankName;
	}

	public void setCustomerBankName(String customerBankName) {
		this.customerBankName = customerBankName;
	}

	public Date getCustomerBirthDate() {
		return this.customerBirthDate;
	}

	public void setCustomerBirthDate(Date customerBirthDate) {
		this.customerBirthDate = customerBirthDate;
	}

	public String getCustomerEmail() {
		return this.customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerIdentityDocumentId() {
		return this.customerIdentityDocumentId;
	}

	public void setCustomerIdentityDocumentId(String customerIdentityDocumentId) {
		this.customerIdentityDocumentId = customerIdentityDocumentId;
	}

	public int getCustomerIdentityDocumentType() {
		return this.customerIdentityDocumentType;
	}

	public void setCustomerIdentityDocumentType(int customerIdentityDocumentType) {
		this.customerIdentityDocumentType = customerIdentityDocumentType;
	}

	public Date getCustomerJoinDate() {
		return this.customerJoinDate;
	}

	public void setCustomerJoinDate(Date customerJoinDate) {
		this.customerJoinDate = customerJoinDate;
	}

	public String getCustomerMobile() {
		return this.customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return this.customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerQqNum() {
		return this.customerQqNum;
	}

	public void setCustomerQqNum(String customerQqNum) {
		this.customerQqNum = customerQqNum;
	}

	public int getCustomerStatus() {
		return this.customerStatus;
	}

	public void setCustomerStatus(int customerStatus) {
		this.customerStatus = customerStatus;
	}

	public String getCustomerStuCardId() {
		return this.customerStuCardId;
	}

	public void setCustomerStuCardId(String customerStuCardId) {
		this.customerStuCardId = customerStuCardId;
	}

	public String getCustomerWechatId() {
		return this.customerWechatId;
	}

	public void setCustomerWechatId(String customerWechatId) {
		this.customerWechatId = customerWechatId;
	}

	public int getIdentityVarifyStatus() {
		return this.identityVarifyStatus;
	}

	public void setIdentityVarifyStatus(int identityVarifyStatus) {
		this.identityVarifyStatus = identityVarifyStatus;
	}

}