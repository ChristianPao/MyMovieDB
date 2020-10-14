package com.pao.moviedb;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MovieController {
	@Autowired
	MovieService movieService;
	@Autowired
	UserService userService;
	@Autowired
	PlanToWatchService planToWatchService;
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam(name="query", required=true) String query) {
		List<Movie> moviesFound=movieService.searchMovieOnline(query);
		model.addAttribute("moviesFound", moviesFound);
		model.addAttribute("query", query);
		return "search";
	}
	
	@PostMapping(path="/addToPlan", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String plan(@RequestParam String imdbID, Principal principal) {
		if(principal==null)
			return "User not logged in.";
		Movie m=movieService.findMovie(imdbID);
		if(movieService.findMovieLocally(imdbID)==null)
			movieService.save(m);
		PlanToWatchKey ptwk= new PlanToWatchKey(userService.findUserByUsername(principal.getName()).getUsername(), movieService.findMovieLocally(imdbID).getImdbID());
		PlanToWatch ptw=new PlanToWatch(userService.findUserByUsername(principal.getName()),
				movieService.findMovieLocally(imdbID),
				ptwk);
		System.out.println(ptw.user+"|"+ptw.movie.title);
		planToWatchService.addToPlan(ptw);
		System.out.println(planToWatchService.findById(ptwk));
		return "Ok.";
	}
}
