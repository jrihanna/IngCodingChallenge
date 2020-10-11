package com.rihanna.ing.codingchallenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class IngUserSecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	IngPasswordEncoder ingPasswordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return ingPasswordEncoder.delegatePasswordEncoder();
	}
}
