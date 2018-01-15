package com.szw.trading.web.security.encoder;

import java.security.SecureRandom;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class MyBCryptPasswordEncoder extends BCryptPasswordEncoder {
	private Pattern BCRYPT_PATTERN = Pattern.compile("\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}");

	private final Logger log = Logger.getLogger(MyBCryptPasswordEncoder.class);

	private final int strength;

	private final SecureRandom random;

	public MyBCryptPasswordEncoder() {
		this(-1);
	}

	/**
	 * @param strength the log rounds to use
	 */
	public MyBCryptPasswordEncoder(int strength) {
		this(strength, null);
	}

	public MyBCryptPasswordEncoder(int strength, SecureRandom random) {
		this.strength = strength;
		this.random = random;
	}

	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}
}
