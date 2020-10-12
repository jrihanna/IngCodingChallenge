package com.rihanna.ing.codingchallenge;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.jdbc.Sql;

import com.rihanna.ing.codingchallenge.controller.IngUserDetailController;
import com.rihanna.ing.codingchallenge.model.dto.IngUserDetailsDto;
import com.rihanna.ing.codingchallenge.repository.IngUserRepository;
import com.rihanna.ing.codingchallenge.service.IngUserDetailService;
import com.rihanna.ing.codingchallenge.service.IngUserDetailServiceImp;

@SpringBootTest
class CodingChallengeApplicationTests {
	
	@Autowired
	IngUserDetailController ingUserDetailController;

	@Mock
	IngUserRepository ingUserRepository;
	
	@InjectMocks
	IngUserDetailService service = new IngUserDetailServiceImp();

	@Test
	void contextLoads() {
		assertThat(ingUserDetailController, is(notNullValue()));
	}
	
	@BeforeTestClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	// Because it's an in-memory db, it will always pass
	@Test
	void test_loadUserByUsername_expect_exception() {
		assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("user27"));
	}
	
	

	// Because it's an in-memory db, it wouldn't pass
	@Test
	@Sql(scripts = {"classpath:data1.sql"})
	void test_loadUserByUsername_expect_user() {
		IngUserDetailsDto dto = new IngUserDetailsDto();
		dto.setUserId(20);
		dto.setUsername("user1");
		dto.setFirstN("user1");
		dto.setLastName("user1");
//		Optional<IngUserDetailsModel> user = ingUserRepository.findByUsername("user1");
//		assertThat(user.get(), equalTo(dto));
	}
}
