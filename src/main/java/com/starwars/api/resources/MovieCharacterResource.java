package com.starwars.api.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.starwars.api.dtos.MovieCharacterDto;
import com.starwars.api.enums.Gender;
import com.starwars.api.enums.SortOrder;
import com.starwars.api.enums.SortParam;
import com.starwars.api.services.MovieCharacterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/character", tags = "Character Services")
@Path("character")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieCharacterResource {
    
	@Inject
	private MovieCharacterService movieCharacterService;
    
    @GET
    @Path("all")
    @ApiOperation("Get all characters")
    public Response all(@QueryParam("sortParam") SortParam sortParam, @QueryParam("sortOrder") SortOrder sortOrder,
    		@QueryParam("filterByGender") Gender filterByGender) throws Exception{	
    	MovieCharacterDto movieCharacterDto = movieCharacterService.getCharacterDto(sortParam, sortOrder, filterByGender);
        return Response.ok()
        		.entity(movieCharacterDto)
                .build();
    }
    
    @GET
    @Path("{movieTitle}")
    @ApiOperation("Get character list of a movie")
    public Response getCharacter(@PathParam("movieTitle") String movieTitle) throws Exception{	
    	MovieCharacterDto movieCharacterDto = movieCharacterService.getCharactersByMovieTitle(movieTitle);
        return Response.ok()
        		.entity(movieCharacterDto)
                .build();
    }
}
