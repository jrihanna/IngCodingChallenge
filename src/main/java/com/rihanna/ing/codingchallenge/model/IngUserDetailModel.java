package com.rihanna.ing.codingchallenge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class IngUserDetailModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

}
