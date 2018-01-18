package com.szw.trading.web.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;


public class AccessDeniedJsonHanlder extends AccessDeniedHandlerImpl {

	private final Logger log = Logger.getLogger(AccessDeniedJsonHanlder.class);

	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
			throws IOException, ServletException {
		log.info("handle on login denied.");
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print("{\"errorCode\": \"ACCESS_DENIED\"}");
		response.getWriter().flush();
	}
}
