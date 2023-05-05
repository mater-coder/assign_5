package com.nagarro.BackendApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.BackendApplication.entities.User;

public interface UserDao extends JpaRepository<User,String> {

}
