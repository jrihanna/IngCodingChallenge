package com.rihanna.ing.codingchallenge.model;

public class AuthenticationResponseModel {
	private final String jwt;

    public AuthenticationResponseModel(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
