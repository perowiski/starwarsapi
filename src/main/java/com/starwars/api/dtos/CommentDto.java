package com.starwars.api.dtos;

public class CommentDto {

	private String movieTitle;
	
	private String commenter;
	
	private String comment;
	
	public CommentDto() {}
	
	public CommentDto(String movieTitle, String commenter, String comment) {
		this.movieTitle = movieTitle;
		this.commenter = commenter;
		this.comment = comment;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}	

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
