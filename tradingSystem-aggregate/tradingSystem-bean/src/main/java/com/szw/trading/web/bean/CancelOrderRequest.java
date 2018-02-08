package com.szw.trading.web.bean;

import org.hibernate.validator.constraints.NotEmpty;


public class CancelOrderRequest extends BaseRequest {
	private static final long serialVersionUID = -2890746058861519056L;
	@NotEmpty(message = "必须输入")
	private String cancelOrderNo;

	public String getCancelOrderNo() {
		return cancelOrderNo;
	}

	public void setCancelOrderNo(String cancelOrderNo) {
		this.cancelOrderNo = cancelOrderNo;
	}

}
