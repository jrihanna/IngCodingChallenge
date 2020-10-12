package com.rihanna.ing.codingchallenge.pact;

import org.springframework.boot.SpringApplication;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.rihanna.ing.codingchallenge.CodingChallengeApplication;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
//import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

//@RunWith(PactRunner.class)
@Provider("test_provider")
@PactFolder("pacts")
public class PactProviderTest {

	@TestTarget
	public final Target target = null;//new HttpTarget("http", "localhost", 8082, "/spring-rest");
	 
	private static ConfigurableWebApplicationContext application;
	 
	@BeforeTestClass
	public static void start() {
	    application = (ConfigurableWebApplicationContext) 
	      SpringApplication.run(CodingChallengeApplication.class);
	}
	
	@State("test GET")
	public void toGetState() { }
	 
	@State("test POST")
	public void toPostState() { }

}
