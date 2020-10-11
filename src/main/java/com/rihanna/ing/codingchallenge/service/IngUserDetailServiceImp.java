package com.rihanna.ing.codingchallenge.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rihanna.ing.codingchallenge.model.IngUserDetailsModel;
import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;
import com.rihanna.ing.codingchallenge.repository.IngUserRepository;

@Service
public class IngUserDetailServiceImp implements IngUserDetailService {
	
	@Autowired
	IngUserRepository ingUserRepository;
	
	@Autowired
    private ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<IngUserDetailsModel> user = ingUserRepository.findByUsername(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(IngUserDetailsDto::new).get();
	}

	@Override
	public void addUser(IngUserDetailsModel user) {
		ingUserRepository.save(user);
	}

	@Override
	public UserDetails findByUserId(long userId) throws UsernameNotFoundException {
		Optional<IngUserDetailsModel> user = ingUserRepository.findById(userId);
		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userId));

        return user.map(IngUserDetailsDto::new).get();
	}

	@Override
	public UserDetails updateUserDetails(IngUserDetailsDto userDto) throws UsernameNotFoundException {
		UserDetails current = findByUserId(userDto.getUserId());

		IngUserDetailsModel model = convertToModel(current, userDto);
		ingUserRepository.save(model);
		return null;
	}
	
	// I could use Mapper but it's just one DTO!
	private IngUserDetailsModel convertToModel(UserDetails current, IngUserDetailsDto dto) {
		
		IngUserDetailsModel model = new IngUserDetailsModel();
		// Like good old days!
		BeanUtils.copyProperties(current, model, getNullPropertyNames(current));
		BeanUtils.copyProperties(dto, model, getNullPropertyNames(dto));
		return model;
	}
	
	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
	
}
