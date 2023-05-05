package com.services;

import com.entities.User;

public interface LoginService {
	public void getAllUsers();

	public User loginUser(String userId, String password);

	public String getUserName();
}
