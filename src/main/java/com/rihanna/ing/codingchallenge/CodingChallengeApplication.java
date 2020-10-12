package com.rihanna.ing.codingchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Start here
 * @author reihanesadat.zekri
 *
 */
@SpringBootApplication
@EnableSwagger2
public class CodingChallengeApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}

}
