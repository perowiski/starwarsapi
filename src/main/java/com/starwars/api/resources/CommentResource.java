package com.starwars.api.resources;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.starwars.api.dtos.CommentDto;
import com.starwars.api.models.Comment;
import com.starwars.api.services.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/comment", tags = "Comment Services")
@Path("comment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
	
	@Inject
	private CommentService commentSevice;
    
    @POST
    @Path("add")
    @ApiOperation("Add a comment for a movie title")
    public Response add(@Valid CommentDto commentDto, @Context UriInfo uriInfo, @Context HttpServletRequest httpServletRequest){
    	Comment comment = commentSevice.addComment(commentDto.getMovieTitle(), httpServletRequest.getRemoteAddr(), 
    			commentDto.getCommenter(), commentDto.getComment());
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(comment.getId().toString());
        return Response.created(builder.build()).build();
    }
    
    @GET
    @Path("all")
    @ApiOperation("Get all comments")
    public Response all(){
    	List<Comment> comments  = commentSevice.getComments();
        return Response.ok()
        		.entity(comments)
                .build();
    }
}
