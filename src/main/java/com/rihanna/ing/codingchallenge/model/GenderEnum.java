package com.rihanna.ing.codingchallenge.model;

public enum GenderEnum {
	FEMALE("female"), MALE("male"), OTHER("other");
	
	private String value;

	private GenderEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
