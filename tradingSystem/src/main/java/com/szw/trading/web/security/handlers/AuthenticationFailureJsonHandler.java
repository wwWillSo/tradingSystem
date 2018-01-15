package com.szw.trading.web.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


public class AuthenticationFailureJsonHandler implements AuthenticationFailureHandler {

	private final Logger log = Logger.getLogger(AuthenticationFailureJsonHandler.class);

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		log.info("handle onAuthenticationFailure.");

		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print("{\"errorCode\": \"ACCESS_FAIL\"}");
		response.getWriter().flush();
	}
}
