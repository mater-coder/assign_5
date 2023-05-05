package com.services;

import java.util.List;

import com.entities.Author;
import com.entities.Book;

public interface BookService {
	public List<Book> getBookList();

	public List<Author> getAuthorList();

	public void addBook(Book book);

	public void deleteBook(int id);

	public Book getBookById(int id);

	public void updateBook(Book book);

}
