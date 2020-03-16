package com.starwars.api.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.starwars.api.models.Movie;

@Stateless
public class MovieRepository {
	
    @PersistenceContext(unitName = "StarWars_PU")
    EntityManager em;
    
    private API api;
    
    @Inject
	public MovieRepository(API api) {
		this.api = api;
	}
    
    public List<Movie> getMovies() throws Exception{
    	JsonObject jsonObject = api.getBuilder("films", null);
    	JsonArray filmResults = jsonObject.getAsJsonArray("results");
    	Gson gson = new Gson();
    	List<Movie> movies= gson.fromJson(filmResults, new TypeToken<List<Movie>>(){}.getType());
    	return movies;
    }
}
