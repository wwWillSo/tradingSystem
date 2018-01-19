package com.szw.trading.web.security.filters;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.szw.util.PasswordUtil;


/*
 * 登录拦截器
 */
public class AuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
	private final Logger log = Logger.getLogger(AuthenticationProcessingFilter.class);

	private final String usernameParameter;
	private final String passwordParameter;

	/**
	 * 获得登陆信息
	 * 
	 * @param defaultFilterProcessesUrl
	 * @param usernameParameter
	 * @param passwordParameter
	 * @param agentIdParameter
	 */
	public AuthenticationProcessingFilter(String defaultFilterProcessesUrl, String usernameParameter, String passwordParameter, String agentIdParameter) {
		super(defaultFilterProcessesUrl);
		this.usernameParameter = usernameParameter;
		this.passwordParameter = passwordParameter;
	}

	/**
	 * 进行验证
	 */
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		if (!request.getMethod().equals("POST")) {				// 只允许post请求
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		String username = request.getParameter(this.usernameParameter);
		String password = request.getParameter(this.passwordParameter);

		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		username = username.trim();

		try {
			// 前端为密码做SHA256+AES加密，后台在这里对密码进行AES解密，然后跟数据库中的密码（依然是被SHA256加密过的）进行比对
			password = PasswordUtil.aesDecrypt(password, PasswordUtil._key);
		} catch (Exception e) {
			e.printStackTrace();
			// 密码错误
		}

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		return getAuthenticationManager().authenticate(authRequest);
	}
}
