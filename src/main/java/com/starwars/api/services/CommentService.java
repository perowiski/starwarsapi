package com.starwars.api.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import com.starwars.api.models.Comment;
import com.starwars.api.repositories.CommentRepository;

@Stateless
public class CommentService {
	
	private CommentRepository commentRepository;
	
	@Inject
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Comment addComment(String movieTitle, String ipAddress, String commenter, String comment) {
		Comment objComment = new Comment(movieTitle, ipAddress, commenter, comment);
		return commentRepository.addComment(objComment);
	}
	
	public List<Comment> getComments(){
		List<Comment> comments =  commentRepository.getComments();
		return comments;
	}
}
