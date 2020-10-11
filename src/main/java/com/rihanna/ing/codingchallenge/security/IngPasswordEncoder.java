package com.rihanna.ing.codingchallenge.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class IngPasswordEncoder {
	
	@SuppressWarnings("unchecked")
	public PasswordEncoder delegatePasswordEncoder() {
		String idForEncode = "bcrypt";
		 Map encoders = new HashMap<>();
		 encoders.put(idForEncode, new BCryptPasswordEncoder());
		 encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		 encoders.put("scrypt", new SCryptPasswordEncoder());
		 // The Spring version I'm using doesn't support ShaPasswordEncoder
		 encoders.put("sha256", new StandardPasswordEncoder());
		 
		 return new DelegatingPasswordEncoder(idForEncode, encoders);
	}

}
