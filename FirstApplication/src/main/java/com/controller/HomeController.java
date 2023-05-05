package com.controller;

import java.util.List;
import com.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.services.BookService;
import com.services.LoginServiceImpl;

@Controller
public class HomeController {

	@Autowired
	private BookService bookService;
	@Autowired
	private LoginServiceImpl loginService;

	@RequestMapping("/add")
	public String add(Model model) {
		List<Author> authorlist = this.bookService.getAuthorList();
		model.addAttribute("authorlist", authorlist);
		return "add";
	}

	@RequestMapping(path = "/addBook", method = RequestMethod.POST)
	public String addBook(@ModelAttribute Book book) {
		System.out.println(book.toString());
		this.bookService.addBook(book);
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public void getBooks(Model model) {
		List<Book> list = this.bookService.getBookList();
		System.out.println("Book lata hun bhai!");
		if (list != null) {
			String name = this.loginService.getUserName();
			if (list.size() > 0) {
				model.addAttribute("booklist", list);
//				String name = this.loginService.getUserName();
				System.out.println("User ka naam hai : " + this.loginService.getUserName());
				model.addAttribute("username", name);
			} else {
				model.addAttribute("username", name);
				model.addAttribute("mssg", "Please click on Add Button to add some Awesome books!");
			}
		} else {
			model.addAttribute("mssg", "Something went wrong on server side!");
		}

	}

	@RequestMapping(path = "/delete-book")
	public String deleteBook(@RequestParam("id") int id, Model model) {
		this.bookService.deleteBook(id);

		return "redirect:/home";
	}

	@RequestMapping(path = "/edit-book")
	public String editBook(@RequestParam("id") int id, Model model) {
		Book book = this.bookService.getBookById(id);
		model.addAttribute("updatebook", book);
		model.addAttribute("authorlist", this.bookService.getAuthorList());
		return "update";
	}

	@RequestMapping(path = "/updateBook")
	public String updateBook(@ModelAttribute Book book) {
		System.out.println(book.toString());
		this.bookService.updateBook(book);
		return "redirect:/home";
	}

}
