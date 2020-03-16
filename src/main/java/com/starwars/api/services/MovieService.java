/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.starwars.api.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

import com.starwars.api.dtos.MovieDto;
import com.starwars.api.models.Movie;
import com.starwars.api.repositories.*;

public class MovieService {

	private MovieRepository movieRepository;
	private CommentRepository commentRepository;
	
	@Inject
	public MovieService(MovieRepository movieRepository, CommentRepository commentRepository) {
		this.movieRepository = movieRepository;
		this.commentRepository = commentRepository;
	}
	
    public MovieDto getMovieDto() throws Exception{
        List<Movie> movies = movieRepository.getMovies();
        List<Movie> results = movies.stream().map(temp -> {
        	Movie movie = temp;
        	movie.setCommentCount(commentRepository.getCommentCountByMovieTitle(temp.getTitle()));
            return movie;
        }).collect(Collectors.toList());
        Comparator<Movie> comparator = (m1, m2) -> m1.getRelease_date().compareTo(m2.getRelease_date());
        results.sort(comparator.reversed());
        MovieDto movieDto = new MovieDto(results);
		return movieDto;
    }
    
}
