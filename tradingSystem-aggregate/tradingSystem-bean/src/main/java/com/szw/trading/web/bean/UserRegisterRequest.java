package com.szw.trading.web.bean;

import org.hibernate.validator.constraints.NotEmpty;


public class UserRegisterRequest extends BaseRequest {

	private static final long serialVersionUID = -8072648088550760339L;
	@NotEmpty(message = "必须输入")
	private String username;
	@NotEmpty(message = "必须输入")
	private String customerName;
	@NotEmpty(message = "必须输入")
	private String password;
	@NotEmpty(message = "必须输入")
	private String confirmPass;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

}
