package com.szw.trading.web.bean;

public class PagingRequest extends BaseRequest {

	private static final long serialVersionUID = 2091261114627351350L;

	private Integer pageNo = 0;
	private Integer pageSize = 10;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
