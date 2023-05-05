package com.nagarro.BackendApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.BackendApplication.dao.UserDao;
import com.nagarro.BackendApplication.entities.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	//Method to get All Users List
	public List<User> getUserList(){
		return this.userDao.findAll();
	}
	
	//Method to make the user login successfully
	public User loginUser(String userId, String password) {
		User user = new User();
		if(userId != null && password != null) {
			if(this.userDao.existsById(userId)) {
				User validUser  = this.userDao.getReferenceById(userId);
				if(validUser.getPassword().equals(password)) {
					validUser.setResponseMssg("Login Success!");
					return validUser;
				}else {
					user.setResponseMssg("Wrong Password!");
				}
			}else {
				user.setResponseMssg("Oops! You are not register with us.");
			}
		}
		return user;
	}
	
	//Method to register a new user with us
	public String RegisterUser(User user) {
		if(user != null) {
			if(!this.userDao.existsById(user.getUserId())) {
				this.userDao.save(user);
			}else {
				return "User Id already taken! Choose another userId";
			}
		}
		return "Thank you for choosing us!";
	}
	
	
	public boolean checkIfIDExist(String userId) {
		return this.userDao.existsById(userId);
	}
}
