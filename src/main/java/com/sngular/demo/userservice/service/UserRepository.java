package com.sngular.demo.userservice.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sngular.demo.userservice.rest.User;

public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);
}
