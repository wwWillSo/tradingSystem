package com.szw.trading.web.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szw.trading.web.bean.CreateOrderRequest;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.service.CustomerService;


@Controller
public class CustomerController {

	private Logger log = Logger.getLogger(getClass());

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/customer/createOrder")
	@ResponseBody
	public Response createOrder(Principal principal, @Valid @RequestBody CreateOrderRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			log.error("【创建订单】loginId=" + principal.getName() + ", " + getValidString(bindingResult));
			return Response.FAILUE(getValidString(bindingResult));
		}

		return customerService.createOrder(principal, request);
	}

	public String getValidString(BindingResult bindingResult) {
		return bindingResult.getFieldError().getField() + bindingResult.getFieldError().getDefaultMessage();
	}
}
