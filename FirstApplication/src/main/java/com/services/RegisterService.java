package com.services;

import com.entities.User;

public interface RegisterService {
	public void registerUser(User user);

	public boolean checkIfExist(String id);
}
