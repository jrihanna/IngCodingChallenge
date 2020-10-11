package com.rihanna.ing.codingchallenge.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.rihanna.ing.codingchallenge.model.IngUserDetailsModel;

public interface IngUserRepository extends CrudRepository<IngUserDetailsModel, Long>{

	 Optional<IngUserDetailsModel> findByUsername(String username);
}
