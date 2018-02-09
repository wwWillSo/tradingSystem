package com.szw.trading.web.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.szw.trading.persistence.entity.Customer;
import com.szw.trading.persistence.entity.CustomerTradingAccount;
import com.szw.trading.persistence.entity.Login;
import com.szw.trading.persistence.repository.CustomerRepository;
import com.szw.trading.persistence.repository.CustomerTradingAccountRepository;
import com.szw.trading.persistence.repository.LoginRepository;
import com.szw.trading.web.bean.PasswordTransformerResponse;
import com.szw.trading.web.bean.Response;
import com.szw.trading.web.bean.UserRegisterRequest;
import com.szw.trading.web.constants.AccountStatus;
import com.szw.trading.web.constants.CustomerStatus;
import com.szw.trading.web.constants.IdentityVarifyStatus;
import com.szw.trading.web.service.BaseService;
import com.szw.trading.web.service.PublicService;
import com.szw.util.PasswordUtil;


@Service
public class PublicServiceImpl extends BaseService implements PublicService {

	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerTradingAccountRepository customerTradingAccountRepository;

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

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public Response userRegister(UserRegisterRequest request) {
		if (!request.getPassword().equals(request.getConfirmPass())) {
			log.info("【用户注册】两次密码输入不一致..." + JSON.toJSONString(request));
			return Response.FAILUE("两次密码输入不一致");
		}

		// 查重
		if (null != loginRepository.findByLoginName(request.getUsername())) {
			log.info("【用户注册】用户名重复...");
			return Response.FAILUE("用户名重复");
		}

		// 解密
		String password = null;
		try {
			password = PasswordUtil.aesDecrypt(request.getPassword(), PasswordUtil._key);
		} catch (Exception e) {
			log.info("【用户注册】密码格式有误...");
			return Response.FAILUE("密码格式有误");
		}

		// login表
		Login login = new Login();
		login.setAgentId(1);
		login.setCreateTime(new Date());
		login.setLoginAccountStatus(AccountStatus.ACTIVE);
		login.setLoginName(request.getUsername());
		login.setLoginPassword(password);

		// customer表
		Customer customer = new Customer();
		customer.setCustomerJoinDate(new Date());
		customer.setCustomerMobile(request.getUsername());
		customer.setCustomerName(request.getCustomerName());
		customer.setCustomerPassword(password);
		customer.setCustomerStatus(CustomerStatus.ACTIVE);
		customer.setIdentityVarifyStatus(IdentityVarifyStatus.UNVARIFY);
		Customer rtnCustomer = customerRepository.save(customer);

		login.setCustomerId(rtnCustomer.getCustomerId());
		Login rtnLogin = loginRepository.save(login);

		// tradingAccount表
		CustomerTradingAccount cta = new CustomerTradingAccount();
		cta.setCustomerId(rtnCustomer.getCustomerId());
		cta.setDepositAmount(BigDecimal.ZERO);
		cta.setUsableAmount(new BigDecimal(100000));
		customerTradingAccountRepository.save(cta);

		log.info("【用户注册】注册成功...username = " + rtnLogin.getLoginName());
		return Response.SUCCESS();
	}
}
