package com.pao.moviedb;

import org.springframework.data.repository.CrudRepository;

public interface MovieRatingRepository extends CrudRepository<MovieRating, String> {
	
}
