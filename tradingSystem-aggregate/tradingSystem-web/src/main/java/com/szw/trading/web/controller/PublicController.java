package com.szw.trading.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szw.trading.web.bean.PasswordTransformerResponse;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.UserRegisterRequest;
import com.szw.trading.web.service.PublicService;


@Controller
public class PublicController extends BaseController {

	@Autowired
	private PublicService publicService;

	@RequestMapping("/api/public/passwordTransformer/{password}")
	@ResponseBody
	public PasswordTransformerResponse passwordTransformer(@PathVariable String password) {
		return this.publicService.passwordTransformer(password);
	}

	@RequestMapping("/api/public/userRegister")
	@ResponseBody
	public Response userRegister(@Valid @RequestBody UserRegisterRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("【用户注册】" + getValidString(bindingResult));
			return Response.FAILUE(getValidString(bindingResult));
		}
		return this.publicService.userRegister(request);
	}
}
