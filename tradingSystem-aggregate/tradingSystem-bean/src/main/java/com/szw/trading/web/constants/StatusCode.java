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
	 * 要卖出的订单号不存在
	 */
	OLD_ORDER_NO_NOT_EXISTS("E0005", "要卖出的订单号不存在"),
	/**
	 * 卖出数与原订单买入数不符
	 */
	QUANTITY_NOT_ENOUGH("E0006", "卖出数与原订单买入数不符"),
	/**
	 * 订单已被取消
	 */
	ORDER_HAS_BEEN_CANCELED("E0007", "订单已被取消"),
	/**
	 * 要卖出的订单状态不能卖出
	 */
	OLD_ORDER_NOT_ALLOW_TO_SELL("E0008", "要卖出的订单状态不能卖出"),

	/**
	 * 未知错误
	 */
	UNKNOWN_ERROR("E500", "系统未知错误"),

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
