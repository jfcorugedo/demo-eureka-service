package com.sngular.demo.userservice.service;

import java.util.Collections;
import java.util.List;

import com.sngular.demo.userservice.rest.User;

public interface UserService {

	User findByEmail(String email);

	User create(User user);

	User findById(String id);

	List<User> getAll();

	void delete(String id);

	User findRandom();

}
