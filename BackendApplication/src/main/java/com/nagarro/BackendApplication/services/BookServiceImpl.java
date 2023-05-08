package com.nagarro.BackendApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.BackendApplication.dao.*;

import com.nagarro.BackendApplication.entities.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private CourseDao courseDao;
	
	public BookServiceImpl() {
		
	}

	//Method to fetch list of books from database!
	public List<Book> getBooks() {
		return courseDao.findAll();
	}
	
	//Method to fetch single book details by book Id!
	public Book getBookById(int id) {
		if(courseDao.existsById(id))
			return courseDao.getReferenceById(id);
		else return null;
	}
	
	//Method to add Book into the database!
	public Book addBook(Book book) {
		return courseDao.save(book);
	}
	
	//Method to update the book details!
	public Book updateBook(Book book) {
		return courseDao.save(book);
	}
	
	//Method to delete a book from database!
	public void deleteBook(int id) {
		courseDao.deleteById(id);
	}
	
	
	

}
