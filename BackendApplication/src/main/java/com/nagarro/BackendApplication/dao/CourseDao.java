package com.nagarro.BackendApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.BackendApplication.entities.Book;

public interface CourseDao extends JpaRepository<Book,Integer> {
	

}
