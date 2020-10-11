package com.rihanna.ing.codingchallenge.model;

public enum TitleEnum {
	MR("mr"), MISS("miss"), MRS("mrs"), MS("ms");
	
	private String value;

	private TitleEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
