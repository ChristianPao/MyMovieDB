package com.pao.moviedb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@RequestParam(name="username", required=true) String username,
			@RequestParam(name="password", required=true) String password,
			HttpServletRequest request) throws ServletException {
		userService.save(new User(username, password));
		request.login(username, password);
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	

	
	
}
