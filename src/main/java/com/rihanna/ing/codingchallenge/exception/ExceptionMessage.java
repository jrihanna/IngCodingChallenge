package com.rihanna.ing.codingchallenge.exception;

public class ExceptionMessage {
	
	private String status = "error";

	private String message;
	
	public ExceptionMessage() {}
	
	public ExceptionMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
