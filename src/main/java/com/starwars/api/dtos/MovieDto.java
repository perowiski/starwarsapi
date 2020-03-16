package com.starwars.api.dtos;

import java.util.List;

import com.starwars.api.models.Movie;

public class MovieDto {
	
	private List<Movie> results;

	public MovieDto(List<Movie> movies){
		this.results = movies;
	}
	
	public List<Movie> getResults() {
		return results;
	}

	public void setResults(List<Movie> movies) {
		this.results = movies;
	}
}
