package com.szw.trading.web.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;


public class BaseController {
	protected Logger log = Logger.getLogger(getClass());

	public String getValidString(BindingResult bindingResult) {
		return bindingResult.getFieldError().getField() + bindingResult.getFieldError().getDefaultMessage();
	}
}
