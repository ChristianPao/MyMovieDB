package com.pao.moviedb;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, String> {
	Movie findByImdbID(String imdbID);
}
