package com.nagarro.BackendApplication.services;

import java.util.List;

import com.nagarro.BackendApplication.entities.Book;

public interface BookService {
	
	public List<Book> getBooks();
	
	public Book getBookById(int id);
	
	public Book addBook(Book book);
	
	public Book updateBook(Book book);
	
	public void deleteBook(int id);
}
