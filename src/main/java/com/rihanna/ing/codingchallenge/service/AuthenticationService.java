package com.rihanna.ing.codingchallenge.service;

import com.rihanna.ing.codingchallenge.model.AuthenticationRequestModel;

public interface AuthenticationService {

	String createAuthenticationToken(AuthenticationRequestModel authenticationRequest) throws Exception;
}
