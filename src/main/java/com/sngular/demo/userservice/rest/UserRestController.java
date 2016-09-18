package com.sngular.demo.userservice.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sngular.demo.userservice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/v1/users")
public class UserRestController {

	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	@ApiOperation(value = "Given the userName and email creates a new user resource")
	@RequestMapping(method=POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		
		User createdUser = userService.create(user);
		
		return ResponseEntity.created(URI.create(createdUser.getId())).body(user);
	}
	
	@ApiOperation(value = "Given a unique ID it will return the user associated with it")
	@RequestMapping(value="{id}", method=GET)
	public ResponseEntity<User> get(@PathVariable String id) {
		
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@ApiOperation(value = "Given an email it will return the user associated with it")
	@RequestMapping(value="/email/{email}", method=GET)
	public ResponseEntity<User> findByEmail(@PathVariable String email) {
		
		return ResponseEntity.ok(userService.findByEmail(email));
	}
	
	@ApiOperation(value = "Returns all the users of the system")
	@RequestMapping(method=GET)
	public ResponseEntity<List<User>> getAll() {
		
		return ResponseEntity.ok(userService.getAll());
	}
	
	@ApiOperation(value = "Removes a user form the system")
	@RequestMapping(value="{id}", method=DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Finds a random user and returns it")
	@RequestMapping(value="/random", method=GET)
	public ResponseEntity<User> findRandom() {
		
		try {
			if(true)Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(userService.findRandom());
	}
}
