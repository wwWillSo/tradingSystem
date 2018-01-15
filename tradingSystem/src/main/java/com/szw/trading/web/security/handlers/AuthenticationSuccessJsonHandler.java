package com.szw.trading.web.security.handlers;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.szw.trading.persistence.entity.Login;
import com.szw.trading.persistence.repository.LoginRepository;

import net.sf.json.JSONObject;


public class AuthenticationSuccessJsonHandler implements AuthenticationSuccessHandler {

	private final Logger log = Logger.getLogger(AuthenticationSuccessJsonHandler.class);
	private int SESSION_TIMEOUT_IN_SECONDS = 60 * 60;

	private LoginRepository loginRepository;

	public AuthenticationSuccessJsonHandler(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	/**
	 * 登录成功后进入此方法
	 */
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("onAuthenticationSuccess");
		log.info("User Authentication: " + authentication);

		// 设置过期时间
		request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		Iterator<? extends GrantedAuthority> iterator = userDetails.getAuthorities().iterator();
		String authorities = "";
		Login login = this.loginRepository.findByLoginId(Integer.valueOf(userDetails.getUsername()));
		StringBuffer userInfo = new StringBuffer();

		userInfo.append("\n" + "LoginId:" + login.getLoginId() + "\n");
		userInfo.append("SessionId:" + request.getSession().getId());
		log.info(userInfo.toString());

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		AuthenticationSuccessJsonResponse authenticationSuccessJsonResponse = new AuthenticationSuccessJsonResponse();
		authenticationSuccessJsonResponse.setStatusCode("ACCESS_GRANTED");
		Collection<String> collections = response.getHeaders("Set-Cookie");
		String[] cookies = new String[2];
		// 每次新的登陆都会有set-cookie，但是仅限于headers里面不带有session/token
		if (collections != null && collections.size() > 0) {
			collections.toArray(cookies);
			authenticationSuccessJsonResponse.setSessionId(cookies[0].substring(cookies[0].indexOf("=") + 1, cookies[0].indexOf(";")));
			authenticationSuccessJsonResponse.setToken(cookies[1].substring(cookies[1].indexOf("=") + 1, cookies[1].indexOf(";")));
		} else {
			// 从每次的request读出信息，但是实际上应该是不存在的，只是用于postman等自动附带session/token信息
			Cookie[] cookie = request.getCookies();
			authenticationSuccessJsonResponse.setSessionId(cookie[0].getValue());
			authenticationSuccessJsonResponse.setToken(cookie[1].getValue());
		}
		response.getWriter().print(JSONObject.fromObject(authenticationSuccessJsonResponse).toString());

		// if (request.getParameter("isWeb") != null) {
		// String isWeb = request.getParameter("isWeb") ;
		// if (isWeb.equals("true")) {
		// request.setAttribute("loginResult", StatusCode.ACCESS_GRANTED.toString());
		//// response.sendRedirect("/index/login.html");
		// request.getRequestDispatcher("/").forward(request, response);
		// }
		// }

		response.getWriter().flush();
	}

	public static String getIpAddress(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
