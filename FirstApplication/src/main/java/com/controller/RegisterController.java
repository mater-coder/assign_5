package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entities.User;
import com.services.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@RequestMapping("/register")
	public String registerPage() {
		return "register";
	}

	@RequestMapping(path = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@RequestParam("userId") String id, @RequestParam("name") String name,
			@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		User user = new User(id, name, email, password);
		if (!this.registerService.checkIfExist(id) && user.getUserId() != null) {
			this.registerService.registerUser(user);
			model.addAttribute("successMssg", "Thank you for connecting with us!");
			return "login";
		} else {
			user.setResponseMssg("UserId : " + id + " already taken! Please choose another one.");
			model.addAttribute("user", user);
		}
		return "register";
	}

}
