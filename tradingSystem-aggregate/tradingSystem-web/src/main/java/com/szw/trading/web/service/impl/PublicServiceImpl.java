package com.szw.trading.web.service.impl;

import org.springframework.stereotype.Service;

import com.szw.trading.web.bean.PasswordTransformerResponse;
import com.szw.trading.web.service.BaseService;
import com.szw.trading.web.service.PublicService;
import com.szw.util.PasswordUtil;


@Service
public class PublicServiceImpl extends BaseService implements PublicService {

	@Override
	public PasswordTransformerResponse passwordTransformer(String password) {
		PasswordTransformerResponse response = new PasswordTransformerResponse();

		String password2 = PasswordUtil.GenHashBySHA256(password, PasswordUtil._salt);

		System.out.println("sha256 : " + password2);

		try {
			String password3 = PasswordUtil.aesEncrypt(password2, PasswordUtil._key);
			System.out.println("aes : " + password3);

			response.setPassword(password3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

}
