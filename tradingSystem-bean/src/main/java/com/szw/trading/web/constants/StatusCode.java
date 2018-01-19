package com.szw.trading.web.constants;

public enum StatusCode {

	/**
	 * 成功
	 */
	SUCCESS("0000", "0000"),

	/**
	 * 交易账户不存在
	 */
	TRADING_ACCOUNT_NOT_EXISTS("E0002", "交易账户不存在"),
	/**
	 * 可用余额不足
	 */
	USABLE_AMOUNT_NOT_ENOUGH("E0003", "可用余额不足"),
	/**
	 * 订单号重复
	 */
	ORDER_NO_EXISTS("E0004", "订单号重复"),

	/**
	 * 失败
	 */
	FAIL("9999", "9999");

	private String code;
	private String desc;

	private StatusCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
}
