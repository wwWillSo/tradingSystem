package com.szw.trading.web.bean;

import java.io.Serializable;


public class Response implements Serializable {
	private static final long serialVersionUID = 6175961815894241618L;
	private String _ReturnCode;
	private String _ReturnMsg;
	private Object data;

	public String get_ReturnCode() {
		return this._ReturnCode;
	}

	public void set_ReturnCode(String _ReturnCode) {
		this._ReturnCode = _ReturnCode;
	}

	public String get_ReturnMsg() {
		return this._ReturnMsg;
	}

	public void set_ReturnMsg(String _ReturnMsg) {
		this._ReturnMsg = _ReturnMsg;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static Response SUCCESS() {
		return SUCCESS((Object) null);
	}

	public static Response SUCCESS(Object data) {
		return RESULT("0000", "SUCCESS", data);
	}

	public static Response FAILUE() {
		return FAILUE("FAILUE");
	}

	public static Response FAILUE(String _ReturnMsg) {
		return FAILUE(_ReturnMsg, (Object) null);
	}

	public static Response FAILUE(String _ReturnMsg, Object data) {
		return RESULT("9999", _ReturnMsg, data);
	}

	public static Response RESULT(String _ReturnCode, String _ReturnMsg) {
		return RESULT(_ReturnCode, _ReturnMsg, (Object) null);
	}

	public static Response RESULT(String _ReturnCode, String _ReturnMsg, Object data) {
		Response rst = new Response();
		rst.set_ReturnCode(_ReturnCode);
		rst.set_ReturnMsg(_ReturnMsg);
		rst.setData(data);
		return rst;
	}
}
