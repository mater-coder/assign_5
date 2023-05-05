package com.nagarro.BackendApplication.services;

import java.util.List;

import com.nagarro.BackendApplication.entities.Author;

public interface AuthorService {
	 List<Author> getAllAuthors();
	 Author addAuthor(Author author);
	 Author getAuthorByName(String name);
	 Author getAuthorById(int id);
	 Author updateAuthor(Author author);
	 void deleteAuthorById(int id);
}
