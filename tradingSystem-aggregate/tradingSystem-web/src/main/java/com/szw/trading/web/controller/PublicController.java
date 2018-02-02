package com.szw.trading.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szw.trading.web.bean.PasswordTransformerResponse;
import com.szw.trading.web.service.PublicService;


@Controller
public class PublicController {

	@Autowired
	private PublicService publicService;

	@RequestMapping("/api/public/passwordTransformer/{password}")
	@ResponseBody
	public PasswordTransformerResponse passwordTransformer(@PathVariable String password) {
		return this.publicService.passwordTransformer(password);
	}
}
