package com.pao.moviedb;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping(value="/")
	public String indexPage(Model model) {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	    String name = loggedInUser.getName();
	    System.out.println(name);
	    model.addAttribute("username", name);
		return "index";
	}
	
	@PostMapping(value="/")
	public String index() {
		return "index";
	}
}
