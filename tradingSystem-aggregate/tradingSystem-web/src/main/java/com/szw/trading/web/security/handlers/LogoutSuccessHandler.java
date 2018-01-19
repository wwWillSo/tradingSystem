package com.szw.trading.web.security.handlers;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;


public class LogoutSuccessHandler implements LogoutHandler {

	private final Logger log = Logger.getLogger(LogoutSuccessHandler.class);

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

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		if (authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Iterator<? extends GrantedAuthority> iterator = userDetails.getAuthorities().iterator();

			System.out.println(request.getSession());
			System.out.println("info" + userDetails.getUsername());

			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			try {
				response.getWriter().print("{\"statusCode\": \"LOGOUT_SUCCESS\"}");
				// if (request.getParameter("isWeb") != null) {
				// String isWeb = request.getParameter("isWeb") ;
				// if (isWeb.equals("true")) {
				// response.sendRedirect("/");
				// }
				// }
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_OK);
			try {
				response.getWriter().print("{\"statusCode\": \"ACCESS_DENIED\"}");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
