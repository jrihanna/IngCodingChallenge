package com.rihanna.ing.codingchallenge.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rihanna.ing.codingchallenge.logging.Log;
import com.rihanna.ing.codingchallenge.model.AuthenticationRequestModel;
import com.rihanna.ing.codingchallenge.model.AuthenticationResponseModel;
import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;
import com.rihanna.ing.codingchallenge.service.AuthenticationService;
import com.rihanna.ing.codingchallenge.service.IngUserDetailService;

/**
 * Main and currently the only controller for the application
 * Used for basic User functions
 * @author reihanesadat.zekri
 *
 */
@RestController
@Validated
public class IngUserDetailController {
    
	Logger logger = LoggerFactory.getLogger(IngUserDetailController.class);

    
	@Autowired
	IngUserDetailService ingUserDetailService;
	
	@Autowired
	AuthenticationService authenticationService;

	/**
	 * Generate a JWT key to be used in other services as login
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */
	@Log // log enter/exit method
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody AuthenticationRequestModel authenticationRequest) throws Exception {
		String jwt = authenticationService.createAuthenticationToken(authenticationRequest);
		return ResponseEntity.ok(new AuthenticationResponseModel(jwt));
	}
	
	/**
	 * Retrieve a user based on its id
	 * @param userId
	 * @return
	 */
	@Log
	@RequestMapping(value = "/api/user/userdetails/{userId}", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getUserDetails(@PathVariable @Valid @Pattern(regexp="^[0-9]+", message="Invalid userId") String userId) {
		UserDetails user = ingUserDetailService.findByUserId(Long.valueOf(userId));
		logger.info("found user");
	    return ResponseEntity.ok(user);
	}

	/**
	 * Update a user. 
	 * Needs ADMIN access.
	 * @param userDetails
	 * @return
	 */
	@Log
	@RequestMapping(value = "/api/user/updatedetails", method= RequestMethod.PUT)
	@ResponseBody
	@Transactional(rollbackFor = Throwable.class)
	public ResponseEntity<?> updateUserDetails(@RequestBody IngUserDetailsDto userDetails) {
    	UserDetails user = ingUserDetailService.updateUserDetails(userDetails);
    	logger.info("updated user");
	    return ResponseEntity.ok(user);
	}
}
