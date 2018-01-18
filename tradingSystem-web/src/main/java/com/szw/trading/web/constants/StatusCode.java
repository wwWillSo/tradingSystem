package com.szw.trading.web.constants;

public enum StatusCode {

	/**
	 * 成功
	 */
	SUCCESS("0000", "0000"),

	/**
	 * 余额不足
	 */
	NOTENOUGH("E0001", "余额不足"),

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
