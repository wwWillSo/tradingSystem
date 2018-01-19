package com.szw.trading.web.config;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.szw.trading.persistence.repository.LoginRepository;
import com.szw.trading.web.security.constants.WebConstants;
import com.szw.trading.web.security.encoder.MyBCryptPasswordEncoder;
import com.szw.trading.web.security.filters.AuthenticationProcessingFilter;
import com.szw.trading.web.security.filters.CsrfHeaderFilter;
import com.szw.trading.web.security.handlers.AccessDeniedJsonHanlder;
import com.szw.trading.web.security.handlers.AuthenticationFailureJsonHandler;
import com.szw.trading.web.security.handlers.AuthenticationSuccessJsonHandler;
import com.szw.trading.web.security.handlers.LogoutSuccessHandler;


@PropertySource({ "file:${user.dir}/config/security.properties" })
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
@Order(2147483640)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final static Logger log = Logger.getLogger(WebSecurityConfig.class);

	@Autowired
	private Environment env;
	@Resource(name = "authenticationService")
	private UserDetailsService authenticationService;
	private String[] publicAccessUrls;
	private AntPathRequestMatcher[] disableCsrfRequestMatchers;

	@Autowired
	private LoginRepository loginRepsitory;

	private AccessDeniedHandler getLoginAccessDeniedHandler() {
		return new AccessDeniedJsonHanlder();
	}

	private CsrfTokenRepository csrfTokenRepository() {
		HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		repository.setHeaderName(WebConstants.CSRF_TOKEN_NAME);
		repository.setParameterName(WebConstants.CSRF_TOKEN_NAME);
		return repository;
	}

	private AuthenticationEntryPoint authenticationEntryPoint() {
		return new AuthenticationEntryPoint() {
			public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
					throws IOException, ServletException {
				log.info("commence on login fail");
				response.setContentType("application/json");
				response.setStatus(401);
				response.getWriter().print("{\"errorCode\": \"ACCESS_DENIED\"}");

				response.getWriter().flush();
			}
		};
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(this.authenticationService).passwordEncoder(new
		// BCryptPasswordEncoder());
		auth.userDetailsService(this.authenticationService).passwordEncoder(new MyBCryptPasswordEncoder());
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	public org.springframework.security.access.event.LoggerListener eventLoggerListener() {
		org.springframework.security.access.event.LoggerListener eventLoggerListener = new org.springframework.security.access.event.LoggerListener();
		return eventLoggerListener;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 设置不拦截规则
		web.ignoring().antMatchers("/api/public/sendPayResult", "/api/public/requestVerificationCode", "/api/public/registerNewUser",
				"/api/public/MarketDataCandleChart", "/api/public/MarketTickDataChart");

	}

	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new CsrfRequestMatcher(this.disableCsrfRequestMatchers));
		http.addFilterAfter(new CsrfHeaderFilter(this.env.getProperty("cors.allowed.origins"), this.env.getProperty("cors.allow.credentials.urls")),
				CsrfFilter.class);
		http.csrf().csrfTokenRepository(csrfTokenRepository());
		http.headers().frameOptions().disable();

		AuthenticationProcessingFilter authenticationProcessingFilter = new AuthenticationProcessingFilter(this.env.getProperty("login.url"),
				this.env.getProperty("login.userParam"), this.env.getProperty("login.passParam"), this.env.getProperty("login.agentParam"));
		authenticationProcessingFilter.setAuthenticationManager(authenticationManagerBean());
		authenticationProcessingFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessJsonHandler(loginRepsitory));

		authenticationProcessingFilter.setAuthenticationFailureHandler(new AuthenticationFailureJsonHandler());

		http.addFilterBefore(authenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint());
		http.exceptionHandling().accessDeniedHandler(getLoginAccessDeniedHandler());

		http.authorizeRequests().antMatchers(new String[] { "/api/customer/**", "/api/project/**", "/ytx/api/customer/**", "/ytx/api/public/**" })
				.hasRole("CUSTOMER");
		http.authorizeRequests().antMatchers(new String[] { "/api/system/**" }).hasRole("SYSTEM");
		http.authorizeRequests().antMatchers(new String[] { "/trade/info", "/trade/**/**/websocket" }).hasAnyRole("CUSTOMER", "SYSTEM");
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher(this.env.getProperty("logout.url")));
		http.authorizeRequests().antMatchers(this.publicAccessUrls).permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		// AccessDecisionManager manager = new A
		http.authorizeRequests().anyRequest().authenticated().and();

		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").usernameParameter("username")
				.passwordParameter("password").permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")
				.addLogoutHandler(new LogoutSuccessHandler()).permitAll().and().rememberMe().key("9D119EE5A2B7DAF6B4DC1EF871D0AC3C").and().exceptionHandling()
				.accessDeniedPage("/exception/403").and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired")
				.sessionRegistry(sessionRegistry());

		// 设置单点登陆
		// session管理
		http.sessionManagement().sessionFixation().changeSessionId().sessionAuthenticationErrorUrl("/").maximumSessions(1).expiredUrl("/")
				.sessionRegistry(sessionRegistry()).maxSessionsPreventsLogin(true);
		// http.sessionManagement().maximumSessions(1);
		//// CompositeSessionAuthenticationStrategy session =
		// http.sessionManagement().configure(http);
		// http.sessionManagement().sessionAuthenticationStrategy(sessionAuthenticationStrategy());
	}

	@PostConstruct
	public void initialization() {
		String publicAccessUrlsStr = this.env.getProperty("public.access.urls");
		log.info("publicAccessUrlsStr: " + publicAccessUrlsStr);
		this.publicAccessUrls = StringUtils.split(publicAccessUrlsStr, ",");
		this.disableCsrfRequestMatchers = new AntPathRequestMatcher[this.publicAccessUrls.length];
		for (int i = 0; i < this.publicAccessUrls.length; i++)
			this.disableCsrfRequestMatchers[i] = new AntPathRequestMatcher(this.publicAccessUrls[i]);
	}

	protected static class CsrfRequestMatcher implements RequestMatcher {
		private final AntPathRequestMatcher[] disableCsrfRequestMatchers;
		private final Pattern allowedMethods = Pattern.compile("^(POST|GET|HEAD|TRACE|OPTIONS)$");

		protected CsrfRequestMatcher(AntPathRequestMatcher[] disableCsrfRequestMatchers) {
			this.disableCsrfRequestMatchers = disableCsrfRequestMatchers;
		}

		public boolean matches(HttpServletRequest request) {
			for (AntPathRequestMatcher rm : this.disableCsrfRequestMatchers) {
				if (rm.matches(request)) {
					log.info("Disabled csrf for requestUrl: " + request.getRequestURI());
					log.info("Disabled csrf for contentPath: " + request.getContextPath());
					return false;
				}
			}
			return !this.allowedMethods.matcher(request.getMethod()).matches();
		}
	}
}
