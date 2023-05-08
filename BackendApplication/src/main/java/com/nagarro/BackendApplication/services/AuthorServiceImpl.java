package com.nagarro.BackendApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.BackendApplication.dao.AuthorDao;
import com.nagarro.BackendApplication.entities.Author;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private AuthorDao authorDao;

	public List<Author> getAllAuthors() {
		return this.authorDao.findAll();
	}

	public Author addAuthor(Author author) {
		return this.authorDao.save(author);
	}

	public Author getAuthorByName(String name) {
		return this.authorDao.findByName(name);
	}

	public Author getAuthorById(int id) {
		return this.authorDao.getReferenceById(id);
	}

	public Author updateAuthor(Author author) {
		return this.authorDao.save(author);
	}

	public void deleteAuthorById(int id) {
		this.authorDao.deleteById(id);
		
	}

}
