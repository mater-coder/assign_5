package com.nagarro.BackendApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.BackendApplication.entities.User;
import com.nagarro.BackendApplication.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return this.userService.getUserList();
	}
	
	@PostMapping("/users")
	public String registerUser(@RequestBody User user) {
		System.out.println("Id :: " + user.getUserId());
		return this.userService.RegisterUser(user);
	}
	
	@GetMapping("/users/{userId}")
	public boolean checkIfIDExist(@PathVariable String userId) {
		return this.userService.checkIfIDExist(userId);
	}
	
	@PostMapping("/users/{userId}/{password}")
	public User loginUser(@PathVariable String userId,
			@PathVariable String password) {
		return this.userService.loginUser(userId, password);
	}

}
