package com.rihanna.ing.codingchallenge.exception;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ResponseBody
public class InvalidParameterException extends ConstraintViolationException{

	public InvalidParameterException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}
	
	public InvalidParameterException(String message,
			Set<? extends ConstraintViolation<?>> constraintViolations) {
		super( "Invalid Parameter", constraintViolations);
		
	}
	
}
