package com.pao.moviedb;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

// https://www.baeldung.com/jpa-many-to-many

@Entity
public class MovieRating {
	@EmbeddedId
	MovieRatingKey id;
	
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name="student_username")
	User user;
	
	@ManyToOne
	@MapsId("imdbID")
	@JoinColumn(name="movie_id")
	Movie movie;
	
	int rating;
}
