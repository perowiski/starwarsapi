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
import com.starwars.api.models.MovieCharacter;

@Stateless
public class MovieCharacterRepository {
	
    @PersistenceContext(unitName = "StarWars_PU")
    EntityManager em;
    
    private API api;
    
    @Inject
	public MovieCharacterRepository(API api) {
		this.api = api;
	}
    
    public List<MovieCharacter> getCharacters() throws Exception{
    	JsonObject jsonObject = api.getBuilder("people", null);
    	JsonArray peopleResults = jsonObject.getAsJsonArray("results");
    	Gson gson = new Gson();
    	List<com.starwars.api.models.MovieCharacter> movieCharacters = gson.fromJson(peopleResults, new TypeToken<List<MovieCharacter>>(){}.getType());
    	return movieCharacters;
    }
    
    public com.starwars.api.models.MovieCharacter getCharacters(String absolutePath) throws Exception{
    	JsonObject jsonObject = api.getBuilder(absolutePath);
    	Gson gson = new Gson();
    	com.starwars.api.models.MovieCharacter movieCharacter = gson.fromJson(jsonObject, MovieCharacter.class);
    	return movieCharacter;
    }
}
