package com.rihanna.ing.codingchallenge.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * An Advice to wrap all the methods and catch their exceptions and send a unified message to the user
 * @author reihanesadat.zekri
 *
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
    public ResponseEntity<ExceptionMessage> handleAccessDeniedException(
      Exception ex, WebRequest request) {
        return new ResponseEntity<ExceptionMessage>(
          new ExceptionMessage(ex.getLocalizedMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
