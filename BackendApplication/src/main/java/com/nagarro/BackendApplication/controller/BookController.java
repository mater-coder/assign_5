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

import com.nagarro.BackendApplication.entities.Book;
import com.nagarro.BackendApplication.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService; 
	
	//Getting all the list of books from service layer
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return this.bookService.getBooks();
	}
	
	//For getting a single book by id
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable String id) {
		return this.bookService.getBookById(Integer.parseInt(id));	
	}
	
	//Method to add a new book
	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		if(book != null)
			return this.bookService.addBook(book);
		else 
			return null;
	}
	
	//Method to update a book
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book book) {
		if(book != null)
			return this.bookService.updateBook(book);
		else 
			return null;
	}
	
	//Method to delete a book
	@DeleteMapping("/books/{id}")
	public String deleteBook(@PathVariable int id) {
		this.bookService.deleteBook(id);
		return "Book with id : " + id + " is successfully deleted!";
	}
	

}
