package com.pao.moviedb;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
	@Id
	String imdbID;
	String title, poster, type;
	// I chose string because some years are "xxxx-xxxx"
	String year;
	Movie(){	
	}
	
	@OneToMany(mappedBy="movie")
	Set<MovieRating> ratings;
	
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
        Movie that= (Movie) o;
        return Objects.equals(imdbID, that.imdbID);
	}
	
	@Override
	public String toString() {
		return "{"+this.title+", year:"+this.year+"}";
	}
}
