package com.rihanna.ing.codingchallenge.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;
import com.rihanna.ing.codingchallenge.security.util.JwtUtil;

class AuthenticationServiceImpTest {
	Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpTest.class);
	
	@Test
	void jwt_isNotNull_test() {
		
		IngUserDetailsDto user = new IngUserDetailsDto();
		user.setUserId(2);
		user.setUsername("user1");
		user.setPassword("1234");
		
		JwtUtil jwtUtil = new JwtUtil();
		
		assertDoesNotThrow(() -> jwtUtil.generateToken(user));
		
	}

}
