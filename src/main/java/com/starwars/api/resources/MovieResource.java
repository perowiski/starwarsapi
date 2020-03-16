package com.starwars.api.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.starwars.api.dtos.MovieDto;
import com.starwars.api.services.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/movie", tags = "Movie Services")
@Path("movie")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieResource {
    
	@Inject
	private MovieService movieSevice;
    
    @GET
    @Path("all")
    @ApiOperation("Get all movies")
    public Response all() throws Exception{
    	MovieDto movieDto  = movieSevice.getMovieDto();
        return Response.ok()
        		.entity(movieDto)
                .build();
    }
}
