package com.nagarro.BackendApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.BackendApplication.entities.Author;

public interface AuthorDao extends JpaRepository<Author,Integer> {
	Author findByName(String name);
}
