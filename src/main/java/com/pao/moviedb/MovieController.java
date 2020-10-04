package com.pao.moviedb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam(name="query", required=true) String query) {
		List<Movie> moviesFound=movieService.searchMovie(query);
		model.addAttribute("moviesFound", moviesFound);
		model.addAttribute("query", query);
		return "search";
	}
}
