package com.rihanna.ing.codingchallenge.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rihanna.ing.codingchallenge.repository.IngUserRepository;

@ExtendWith(MockitoExtension.class)
class IngUserDetailServiceTest {
	
	
	@Mock
	IngUserRepository ingUserRepository;
	
	@InjectMocks
	IngUserDetailService service = new IngUserDetailServiceImp();

	
	

}
