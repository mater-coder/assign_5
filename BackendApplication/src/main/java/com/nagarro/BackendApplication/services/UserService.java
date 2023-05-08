package com.nagarro.BackendApplication.services;

import java.util.List;

import com.nagarro.BackendApplication.entities.User;

public interface UserService {
	public List<User> getUserList();
	public User loginUser(String userId,String password);
	public String RegisterUser(User user);
	public boolean checkIfIDExist(String userId);
}
