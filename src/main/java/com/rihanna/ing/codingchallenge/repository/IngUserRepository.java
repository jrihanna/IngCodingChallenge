package com.rihanna.ing.codingchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rihanna.ing.codingchallenge.model.IngUserDetailModel;

public interface IngUserRepository extends JpaRepository<IngUserDetailModel, Long>{

}
