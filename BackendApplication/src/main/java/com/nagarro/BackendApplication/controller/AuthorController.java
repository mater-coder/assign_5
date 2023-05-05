package com.nagarro.BackendApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.BackendApplication.entities.Author;
import com.nagarro.BackendApplication.services.AuthorService;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	//Method to get All Authors
	@GetMapping("/authors")
	public List<Author> getAllAuthors(){
		return this.authorService.getAllAuthors();
	}
	
	//Method to add new Author
	@PostMapping("/authors")
	public Author addAuthor(@RequestBody Author author) {
		return this.authorService.addAuthor(author);
	}
	
	//Method to get author by Id
	@GetMapping("/authors/{authorId}")
	public Author getAuthorById(@PathVariable String id) {
		return this.authorService.getAuthorById(Integer.parseInt(id));
	}
	
	//Method to get author by Name
	@GetMapping("/authors/{name}")
	public Author getAuthorByName(@PathVariable String name) {
		return this.authorService.getAuthorByName(name);
	}
	
	//Method to update author
	@PutMapping("/authors")
	public Author updateAuthor(@RequestBody Author author) {
		return this.authorService.updateAuthor(author);
	}
	
	//Method to delete author by Id
	@DeleteMapping("/authors/{authorId}")
	public String deleteAuthor(@PathVariable String id) {
		this.authorService.deleteAuthorById(Integer.parseInt(id));
		return "Author deleted Successfully!";
	}

}
