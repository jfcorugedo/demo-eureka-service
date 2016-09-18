package com.sngular.demo.userservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sngular.demo.userservice.rest.User;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User create(User user) {
		return this.userRepository.save(user);
	}
	
	@Override
	public User findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	@Override
	public User findById(String id) {
		return this.userRepository.findOne(id);
	}
	
	@Override
	public List<User> getAll() {
		return this.userRepository.findAll();
	}
	
	@Override
	public void delete(String id) {
		this.userRepository.delete(id);
	}
	
	@Override
	public User findRandom() {
		List<User> users = this.userRepository.findAll();
		Collections.shuffle(users);
		return users.get(0);
	}
}
