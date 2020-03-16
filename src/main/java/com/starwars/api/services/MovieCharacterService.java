package com.starwars.api.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.inject.Inject;
import com.starwars.api.dtos.MovieCharacterDto;
import com.starwars.api.enums.Gender;
import com.starwars.api.enums.SortOrder;
import com.starwars.api.enums.SortParam;
import com.starwars.api.models.Movie;
import com.starwars.api.repositories.MovieCharacterRepository;
import com.starwars.api.repositories.MovieRepository;
import com.starwars.api.utilities.MetricConverter;

public class MovieCharacterService {

	private MovieCharacterRepository movieCharacterRepository;
	private MovieRepository movieRepository;
	
	@Inject
	public MovieCharacterService(MovieCharacterRepository movieCharacterRepository, MovieRepository movieRepository) {
		this.movieCharacterRepository = movieCharacterRepository;
		this.movieRepository = movieRepository;
	}
	
    public MovieCharacterDto getCharacterDto(SortParam sortParam, SortOrder sortOrder, Gender filterByGender) throws Exception{
        List<com.starwars.api.models.MovieCharacter> movieCharacters = movieCharacterRepository.getCharacters();
        Stream<com.starwars.api.models.MovieCharacter> streamCharacters = movieCharacters.stream();
        
        if(sortParam == SortParam.NAME) {
        	Comparator<com.starwars.api.models.MovieCharacter> comparator = Comparator.comparing(com.starwars.api.models.MovieCharacter::getName);
        	if(sortOrder == SortOrder.DESC) {
        		comparator = comparator.reversed();
        	}
        	streamCharacters = streamCharacters.sorted(comparator);
        }
        if(sortParam == SortParam.GENDER) {
        	Comparator<com.starwars.api.models.MovieCharacter> comparator = Comparator.comparing(com.starwars.api.models.MovieCharacter::getGender);
        	if(sortOrder == SortOrder.DESC) {
        		comparator = comparator.reversed();
        	}
        	streamCharacters = streamCharacters.sorted(comparator);
        }
        if(sortParam == SortParam.HEIGHT) {
        	Comparator<com.starwars.api.models.MovieCharacter> comparator = Comparator.comparing(com.starwars.api.models.MovieCharacter::getHeight);
        	if(sortOrder == SortOrder.DESC) {
        		comparator = comparator.reversed();
        	}
        	streamCharacters = streamCharacters.sorted(comparator);
        }
        if(filterByGender != null) {
        	streamCharacters = streamCharacters
        			.filter(p -> p.getGender().toUpperCase().equals(filterByGender.name()));
        }

        
        List<com.starwars.api.models.MovieCharacter> results = streamCharacters.collect(Collectors.toList());
        long totalHeightOfCharactersInCM = results.stream().mapToInt(com.starwars.api.models.MovieCharacter::retrieveHeight).sum();
		long totalNumberOfCharacters = results.size();
		double totalHeightOfCharactersInInch = MetricConverter.convertCentimetreToInch(totalHeightOfCharactersInCM);
		
        MovieCharacterDto movieCharacterDto = new MovieCharacterDto(results, new MovieCharacterDto.Metadata(totalNumberOfCharacters, totalHeightOfCharactersInCM, totalHeightOfCharactersInInch));
        return movieCharacterDto;
    }
    
    public MovieCharacterDto getCharactersByMovieTitle(String movieTitle) throws Exception{
        List<Movie> movies = movieRepository.getMovies();
        List<com.starwars.api.models.MovieCharacter> characterList = new ArrayList<>();
        for(Movie movie : movies) {
        	if(movie.getTitle().equals(movieTitle)) {
            	List<String> characterURIs =  movie.getCharacters();
            	for(String characterURI : characterURIs) {
            		com.starwars.api.models.MovieCharacter movieCharacter = movieCharacterRepository.getCharacters(characterURI);
            		characterList.add(movieCharacter);
            	}
        	}
        }
        MovieCharacterDto movieCharacterDto = new MovieCharacterDto(characterList);
        return movieCharacterDto;
    }
}
