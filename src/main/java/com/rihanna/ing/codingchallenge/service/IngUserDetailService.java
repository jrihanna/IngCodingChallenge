package com.rihanna.ing.codingchallenge.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rihanna.ing.codingchallenge.model.IngUserDetailModel;
import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;

public interface IngUserDetailService extends UserDetailsService {

	void addUser(IngUserDetailModel user);
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	UserDetails findByUserId(long userId) throws UsernameNotFoundException;
	UserDetails updateUserDetails(IngUserDetailsDto userDto) throws UsernameNotFoundException;
}
