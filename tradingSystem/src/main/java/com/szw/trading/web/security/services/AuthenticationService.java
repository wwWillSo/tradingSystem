package com.szw.trading.web.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.szw.trading.persistence.entity.Customer;
import com.szw.trading.persistence.entity.Login;
import com.szw.trading.persistence.repository.CustomerRepository;
import com.szw.trading.persistence.repository.LoginRepository;


@PropertySource({ "file:${user.dir}/config/sysuser.properties" })
@Service(value = "authenticationService")
public class AuthenticationService implements UserDetailsService {

	private final Logger log = Logger.getLogger(AuthenticationService.class);

	@Autowired
	private Environment env;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		List<OperatorRole> autorities = new ArrayList<OperatorRole>();
		User userInfo = new UserAuthenticateInfo("", "", loginName, "", false, false, false, false, autorities);

		if (!StringUtils.equals(loginName, this.env.getProperty("system.userid"))) {
			String userName;

			userName = loginName;

			Login login = this.loginRepository.findByLoginName(userName);

			if (null == login) {
				return userInfo;
			}

			log.info(login.getLoginName() + " : " + login.getLoginPassword());

			Customer customer = this.customerRepository.findByCustomerId(login.getCustomerId());

			autorities.add(new OperatorRole("ROLE_CUSTOMER"));
			boolean enable = false;
			boolean accountNonLocked = false;
			enable = (login.getLoginAccountStatus() == 0 ? true : false);
			accountNonLocked = (login.getLoginAccountStatus() == 0 ? true : false);

			userInfo = new UserAuthenticateInfo(customer.getCustomerMobile(), customer.getCustomerName(), String.valueOf(login.getLoginId()),
					login.getLoginPassword(), enable, true, true, accountNonLocked, autorities);
		} else {
			autorities.add(new OperatorRole("ROLE_SYSTEM"));

			userInfo = new UserAuthenticateInfo(loginName, this.env.getProperty("system.username"), this.env.getProperty("system.username"),
					this.env.getProperty("system.password"), true, true, true, true, autorities);
		}

		return userInfo;
	}

	public static class UserAuthenticateInfo extends User {
		private static final long serialVersionUID = 1L;
		private String userId;
		private String alias;

		public UserAuthenticateInfo(String userId, String alias, String username, String password, boolean enabled, boolean accountNonExpired,
				boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
			super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			setUserId(userId);
			setAlias(alias);
		}

		public String getUserId() {
			return this.userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getAlias() {
			return this.alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}
	}

	public static class OperatorRole implements GrantedAuthority {
		private static final long serialVersionUID = 1L;
		private String roleType;

		public OperatorRole() {
		}

		public OperatorRole(String roleType) {
			this.roleType = roleType;
		}

		public String getAuthority() {
			return this.roleType;
		}
	}
}
