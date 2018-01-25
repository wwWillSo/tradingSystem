package com.szw.trading.web.service;

import java.security.Principal;

import com.szw.trading.web.bean.CreateOrderRequest;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.SearchRequest;


public interface CustomerService {
	public Response createOrder(Principal principal, CreateOrderRequest request);

	public Response queryOrder(Principal principal, SearchRequest request);
}
