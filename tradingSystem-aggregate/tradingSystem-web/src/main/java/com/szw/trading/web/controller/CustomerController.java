package com.szw.trading.web.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szw.trading.web.bean.CancelOrderRequest;
import com.szw.trading.web.bean.CreateOrderRequest;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.SearchRequest;
import com.szw.trading.web.service.CustomerService;


@Controller
public class CustomerController {

	private Logger log = Logger.getLogger(getClass());

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/api/customer/createOrder")
	@ResponseBody
	public Response createOrder(Principal principal, @Valid @RequestBody CreateOrderRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			log.error("【创建订单】loginId=" + principal.getName() + ", " + getValidString(bindingResult));
			return Response.FAILUE(getValidString(bindingResult));
		}

		return customerService.createOrder(principal, request);
	}

	@RequestMapping("/api/customer/cancelOrder")
	@ResponseBody
	public Response cancelOrder(Principal principal, @Valid @RequestBody CancelOrderRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			log.error("【取消订单】loginId=" + principal.getName() + ", " + getValidString(bindingResult));
			return Response.FAILUE(getValidString(bindingResult));
		}

		return customerService.cancelOrder(principal, request);
	}

	@RequestMapping("/api/customer/queryOrder")
	@ResponseBody
	public Response queryOrder(Principal principal, @RequestBody SearchRequest request, HttpServletRequest hsRequest) {
		log.info("查询订单接口sessionID = " + hsRequest.getSession().getId());
		return customerService.queryOrder(principal, request);
	}

	public String getValidString(BindingResult bindingResult) {
		return bindingResult.getFieldError().getField() + bindingResult.getFieldError().getDefaultMessage();
	}

	@RequestMapping("/api/customer/queryInvestmentSummary")
	@ResponseBody
	public Response queryInvestmentSummary(Principal principal, @RequestBody SearchRequest request) {
		return customerService.queryInvestmentSummary(principal, request);
	}

	@RequestMapping("/api/customer/queryAccount")
	@ResponseBody
	public Response queryAccount(Principal principal) {
		return customerService.queryAccount(principal);
	}
}
