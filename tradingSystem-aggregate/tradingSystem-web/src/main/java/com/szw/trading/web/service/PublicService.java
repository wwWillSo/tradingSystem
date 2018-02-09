package com.szw.trading.web.service;

import com.szw.trading.web.bean.PasswordTransformerResponse;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.UserRegisterRequest;


public interface PublicService {

	PasswordTransformerResponse passwordTransformer(String password);

	Response userRegister(UserRegisterRequest request);

}
