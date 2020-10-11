package com.rihanna.ing.codingchallenge.pact;

import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

public class PactContractTest {

	@Rule
	public PactProviderRule mockProvider
	  = new PactProviderRule("test_provider", "localhost", 8080, this);
	
	@Pact(consumer = "test_consumer")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
	    Map<String, String> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	 
	    return builder
	      .given("test GET")
	        .uponReceiving("GET REQUEST")
	        .path("/pact")
	        .method("GET")
	      .willRespondWith()
	        .status(200)
	        .headers(headers)
	        .body("")
	      .given("test POST")
	        .uponReceiving("POST REQUEST")
	        .method("POST")
	        .headers(headers)
	        .body("")
	        .path("/pact")
	      .willRespondWith()
	        .status(201)
	      .toPact();
	        
	}
	
	@Test
	@PactVerification()
	public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {
	    ResponseEntity<String> response = new RestTemplate()
	      .getForEntity(mockProvider.getUrl() + "/pact", String.class);
	 
	    assertThat(response.getStatusCode().value(),is(equalTo(200)));
	    assertThat(response.getHeaders().get("Content-Type"),anyOf(is("application/json")));
	    assertThat(response.getBody(),allOf(is(""), is(""), is(""), is("")));
	}
	
	@Test
	@PactVerification()
	public void givenPost_whenSendRequest_shouldReturn200WithProperHeaderAndBody() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		String jsonBody = "";
		
		ResponseEntity<String> postResponse = new RestTemplate()
		  .exchange(
		    mockProvider.getUrl() + "/create",
		    HttpMethod.POST,
		    new HttpEntity<>(jsonBody, httpHeaders), 
		    String.class
		);
		
		assertThat(postResponse.getStatusCode().value(),is(equalTo(201)));

	}
}
