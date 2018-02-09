package com.szw.trading.web.service;

import java.security.Principal;

import com.szw.trading.web.bean.CancelOrderRequest;
import com.szw.trading.web.bean.CreateOrderRequest;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.SearchRequest;


public interface CustomerService {
	Response createOrder(Principal principal, CreateOrderRequest request);

	Response queryOrder(Principal principal, SearchRequest request);

	Response cancelOrder(Principal principal, CancelOrderRequest request);

	Response queryInvestmentSummary(Principal principal, SearchRequest request);

	Response queryAccount(Principal principal);
}
