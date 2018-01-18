package com.szw.trading.web.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;


public class CsrfHeaderFilter extends OncePerRequestFilter {

	private final Logger log = Logger.getLogger(CsrfHeaderFilter.class);

	private final String[] accessControlAllowOrigins;
	private final String[] allowCredentialsUrls;

	public CsrfHeaderFilter(final String pAccessControlAllowOrigins, final String pAllowCredentialsUrls) {
		this.accessControlAllowOrigins = StringUtils.split(pAccessControlAllowOrigins, ",");
		this.allowCredentialsUrls = StringUtils.split(pAllowCredentialsUrls, ",");
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		// if(StringUtils.isEmpty(request.getHeader(csrf.getHeaderName()))){
		// Map<String,String> headerMap = new HashMap<>();
		// headerMap.put(csrf.getHeaderName(),WebUtils.getCookie(request, "XSRF-TOKEN").getValue());
		// request = new HeaderAddRequest(request, headerMap);
		// }
		if (csrf != null) {
			log.info("token:" + csrf.getToken());
			log.info("header token:" + request.getHeader(csrf.getHeaderName()));
			Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
			final String token = csrf.getToken();
			if ((cookie == null) || ((token != null) && (!token.equals(cookie.getValue())))) {
				cookie = new Cookie("XSRF-TOKEN", token);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		// request.setAttribute(CsrfToken.class.getName(), csrf);
		// request.setAttribute(csrf.getParameterName(), csrf);
		// System.out.println(request.getHeader("XSRF-TOKEN"));
		// System.out.println(request.getHeader("Content-Type"));
		// for(Cookie one:request.getCookies()){
		// System.out.println(one.getName()+":"+one.getValue());
		// }

		if (this.accessControlAllowOrigins[0].equals("*")) {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		} else {

			final String requestUrl = request.getRequestURL().toString();
			log.info(requestUrl);
			log.info("CsrfHeaderFilter requestUrl: " + requestUrl);
			for (final String origin : this.accessControlAllowOrigins) {
				if (StringUtils.contains(requestUrl, origin)) {
					response.addHeader("Access-Control-Allow-Origin", origin);
					response.addHeader("X-Frame-Options", "ALLOW-FROM " + origin);
				}
				if (StringUtils.equalsIgnoreCase(origin, "null")) {
					response.addHeader("Access-Control-Allow-Origin", origin);
					response.addHeader("X-Frame-Options", "ALLOW-FROM " + origin);
				}
			}
			final String requestURI = request.getRequestURI().toString();
			log.info("CsrfHeaderFilter requestURI: " + requestURI);
			for (final String allowCredentialsUrl : this.allowCredentialsUrls) {
				if (StringUtils.equalsIgnoreCase(requestURI, allowCredentialsUrl)) {
					response.addHeader("Access-Control-Allow-Credentials", "true");
				}
			}

		}
		filterChain.doFilter(request, response);
	}

}
