package com.szw.trading.web.bean;

public class SearchRequest extends PagingRequest {

	private static final long serialVersionUID = 5046266593342332855L;

	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
