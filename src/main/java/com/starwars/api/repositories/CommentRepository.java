package com.starwars.api.repositories;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.starwars.api.models.Comment;


@Stateless
public class CommentRepository {

    @PersistenceContext(unitName = "StarWars_PU")
    EntityManager em;
    
    public CommentRepository() {}
    
    public Comment addComment(Comment comment) {
    	em.persist(comment);
    	return em.find(Comment.class, comment.getId());
    }
    
    public List<Comment> getComments(){
    	return em.createQuery("SELECT c FROM Comment c ", Comment.class).getResultList();
    }

	public long getCommentCountByMovieTitle(String movieTitle) {
		return em.createQuery("SELECT COUNT(c) FROM Comment c WHERE c.movieTitle=:movieTitle ", Long.class)
				.setParameter("movieTitle", movieTitle)
				.getSingleResult();
	}

    
}
