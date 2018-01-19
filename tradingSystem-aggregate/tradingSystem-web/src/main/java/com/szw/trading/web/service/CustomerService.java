package com.szw.trading.web.service;

import java.security.Principal;

import com.szw.trading.web.bean.CreateOrderRequest;
import com.szw.trading.web.bean.Response;


public interface CustomerService {
	public Response createOrder(Principal principal, CreateOrderRequest request);
}
