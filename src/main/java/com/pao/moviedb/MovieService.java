package com.pao.moviedb;

import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.Unirest;

@Service
public class MovieService {

	public List<Movie> searchMovie(String query){
		/*
		 * http://www.omdbapi.com/ 
		 * https://rapidapi.com/hmerritt/api/imdb-internet-movie-database-unofficial?endpoint=apiendpoint_
		 */
		String response=Unirest.get("http://omdbapi.com")
		.queryString("s", query)
		.queryString("apikey", ":-)")
		.asJson()
		.getBody()
		.getObject()
		.getJSONArray("Search")
		.toString();
		List<Movie> moviesFound=null;
		try {
			moviesFound = Arrays.asList(new ObjectMapper().configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true).readValue(response, Movie[].class));
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moviesFound;
	}
}
