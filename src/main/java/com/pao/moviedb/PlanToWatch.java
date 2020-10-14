package com.pao.moviedb;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class PlanToWatch {
	@EmbeddedId
	PlanToWatchKey id;
	
	@ManyToOne
	@MapsId("username")
	@JoinColumn(name="student_username")
	User user;
	
	@ManyToOne
	@MapsId("imdbID")
	@JoinColumn(name="movie_id")
	Movie movie;
	
	public PlanToWatch(User u, Movie m, PlanToWatchKey id) {
		user=u;
		movie=m;
		this.id=id;
	}
	
	public PlanToWatch() {
	}

	public PlanToWatchKey getId() {
		return id;
	}

	public void setId(PlanToWatchKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanToWatch that = (PlanToWatch) o;
        return user.equals(that.user) &&
        		movie.equals(that.movie);
    }
	
	@Override
	public String toString() {
		return "{Planned: "+this.movie+"; by "+this.user+"}";
	}
}
