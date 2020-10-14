package com.pao.moviedb;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PlanToWatchKey implements Serializable {
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="username")
	String username;
	
	@Column(name="movie_id")
	String movieId;
	
	public PlanToWatchKey() {
	}
	public PlanToWatchKey(String username, String movieId) {
		this.username=username;
		this.movieId=movieId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanToWatchKey that = (PlanToWatchKey) o;
        return username.equals(that.username) &&
                movieId.equals(that.movieId);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(username, movieId);
    }
}
