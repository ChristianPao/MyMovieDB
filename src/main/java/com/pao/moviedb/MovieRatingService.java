package com.pao.moviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieRatingService {
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	MovieRatingRepository movieRatingRepository;
	
	public void ssss(String imdbID) {
		/*
		Movie m=movieRepository.findByImdbID(imdbID);
		if(m==null)
			movieRepository.save(m);
		*/
	}
}
