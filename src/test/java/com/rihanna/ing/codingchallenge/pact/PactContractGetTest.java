package com.rihanna.ing.codingchallenge.pact;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.PactTestExecutionContext;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.ContentType;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "ing_provider")
class PactContractGetTest {
	

	@Test
	@Pact(consumer = "ing_consumer", provider = "ing_provider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
	    Map<String, String> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWhhbm5hIiwiZXhwIjoxNjAyODIyNTkyLCJpYXQiOjE2MDI0NjI1OTJ9.VpOcjfdHl11_w61VUwtKiiZrXPzcwVYceKQQId-9STE");
	 
	    return builder
	      .given("test GET")
	        .uponReceiving("GET REQUEST")
	        .path("/api/user/userdetails/1")
	        .method("GET")
	      .willRespondWith()
	        .status(200)
	        .headers(headers)
	      .toPact();
	        
	}
	
	@Test
	public void givenGet_whenSendRequest_shouldReturn200WithProperHeaderAndBody(MockServer mockServer) {

		HttpResponse response = null;
	    try {
	    	response = Request.Get(mockServer.getUrl() + "/api/user/userdetails/1")
					// Not needed but just in case
					.setHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWhhbm5hIiwiZXhwIjoxNjAyODIyNTkyLCJpYXQiOjE2MDI0NjI1OTJ9.VpOcjfdHl11_w61VUwtKiiZrXPzcwVYceKQQId-9STE")
					.execute().returnResponse();
		} catch (IOException e) {
			fail("Failed " + e.getMessage());
		}

	    assertThat(response.getStatusLine().getStatusCode(),is(equalTo(200)));
	}
	
}
