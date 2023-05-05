package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entities.User;
import com.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String login() {
		System.out.println("Login Loaded!");
		return "login";
	}

	@RequestMapping(path = "/userlogin", method = RequestMethod.POST)
	public String getUser(@RequestParam("userId") String userId, @RequestParam("password") String pass, Model m) {
		System.out.println(userId + pass);
		User user = this.loginService.loginUser(userId, pass);
		System.out.println(user.toString());
		System.out.println("user name : " + user.getName());
		m.addAttribute("loginMssg", user.getResponseMssg());
		if (user != null && user.getName() != null) {
			m.addAttribute("user", user);
			return "redirect:/home";
		}
		return "login";
	}
}
