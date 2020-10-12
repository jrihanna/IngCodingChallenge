package com.rihanna.ing.codingchallenge.pact;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;


@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "ing_provider")
public class PactContractPostTest {

	@Test
	@Pact(consumer = "ing_consumer", provider = "ing_provider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
	    Map<String, String> headers = new HashMap<>();
	    headers.put("Content-Type", "application/json");
	    headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWhhbm5hIiwiZXhwIjoxNjAyODIyNTkyLCJpYXQiOjE2MDI0NjI1OTJ9.VpOcjfdHl11_w61VUwtKiiZrXPzcwVYceKQQId-9STE");
	 
	    return builder
	      .given("test POST")
	        .uponReceiving("POST REQUEST")
	        .method("POST")
	        .headers(headers)
	        .body("{\"userId\":3, \"firstN\":\"ssd\"}")
	        .path("/api/user/updatedetails")
	      .willRespondWith()
	        .status(200)
	      .toPact();
	        
	}
	
	
	@Test
	public void givenPost_whenSendRequest_shouldReturn200WithProperHeaderAndBody(MockServer mockServer) {

		HttpResponse response;
		try {
			response = Request.Post(mockServer.getUrl() + "/api/user/updatedetails").setHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyaWhhbm5hIiwiZXhwIjoxNjAyODIyNTkyLCJpYXQiOjE2MDI0NjI1OTJ9.VpOcjfdHl11_w61VUwtKiiZrXPzcwVYceKQQId-9STE")
					.bodyString("{\"userId\":3, \"firstN\":\"ssd\"}", org.apache.http.entity.ContentType.APPLICATION_JSON).execute().returnResponse();

			assertThat(response.getStatusLine().getStatusCode(),is(equalTo(200)));
		} catch (IOException e) {
			fail("Failed");
		}

	}
}
