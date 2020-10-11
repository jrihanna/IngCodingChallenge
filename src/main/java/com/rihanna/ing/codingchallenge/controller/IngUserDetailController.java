package com.rihanna.ing.codingchallenge.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rihanna.ing.codingchallenge.model.AuthenticationRequestModel;
import com.rihanna.ing.codingchallenge.model.AuthenticationResponseModel;
import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;
import com.rihanna.ing.codingchallenge.service.AuthenticationService;
import com.rihanna.ing.codingchallenge.service.IngUserDetailService;


@RestController
public class IngUserDetailController {
	@Autowired
	IngUserDetailService ingUserDetailService;
	
	@Autowired
	AuthenticationService authenticationService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody AuthenticationRequestModel authenticationRequest) throws Exception {
		String jwt = authenticationService.createAuthenticationToken(authenticationRequest);
		return ResponseEntity.ok(new AuthenticationResponseModel(jwt));
	}
	
	@RequestMapping(value = "/api/user/userdetails/{userId}", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getUserDetails(@PathVariable Long userId) {
		try {
			UserDetails user = ingUserDetailService.findByUserId(userId);
		    return ResponseEntity.ok(user);
		} catch(UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/api/user/updatedetails", method= RequestMethod.PUT)
	@ResponseBody
	@Transactional(rollbackFor = Throwable.class)
	public ResponseEntity<?> updateUserDetails(@RequestBody IngUserDetailsDto userDetails) {
	    try {
	    	UserDetails user = ingUserDetailService.updateUserDetails(userDetails);
		    return ResponseEntity.ok(user);
		} catch(UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
