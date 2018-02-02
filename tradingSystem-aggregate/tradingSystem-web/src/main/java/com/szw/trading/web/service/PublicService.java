package com.szw.trading.web.service;

import com.szw.trading.web.bean.PasswordTransformerResponse;


public interface PublicService {

	PasswordTransformerResponse passwordTransformer(String password);

}
