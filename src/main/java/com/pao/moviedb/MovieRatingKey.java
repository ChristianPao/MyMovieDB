package com.pao.moviedb;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovieRatingKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="username")
	String username;
	
	@Column(name="movie_id")
	String movieId;
}
