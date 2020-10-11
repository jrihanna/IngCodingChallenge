package com.rihanna.ing.codingchallenge.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rihanna.ing.codingchallenge.model.IngUserDetailModel;
import com.rihanna.ing.codingchallenge.model.IngUserLoginDetails;
import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;
import com.rihanna.ing.codingchallenge.repository.IngUserRepository;

@Service
public class IngUserDetailServiceImp implements IngUserDetailService {
	
	@Autowired
	IngUserRepository ingUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<IngUserLoginDetails> user = ingUserRepository.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(IngUserDetailsDto::new).get();
	}

	@Override
	public void addUser(IngUserDetailModel user) {
		ingUserRepository.save(user.getUserInfo());
	}

	@Override
	public UserDetails findByUserId(long userId) throws UsernameNotFoundException {
		Optional<IngUserLoginDetails> user = ingUserRepository.findById(userId);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userId));

        return user.map(IngUserDetailsDto::new).get();
	}

	@Override
	public UserDetails updateUserDetails(IngUserDetailsDto userDto) throws UsernameNotFoundException {
		
		return null;
	}
	
	// I could use Mapper but for one DTO it's not worth it!
	private IngUserDetailModel convertToModel(IngUserDetailsDto userDto) {
		return new IngUserDetailModel(userDto);
	}
	
}
