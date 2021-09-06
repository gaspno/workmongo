package com.mog.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String comment;
	private Date data;
	private AuthorDto author;
	
	public CommentDto() {
		
	}

	public CommentDto(String comment, Date data, AuthorDto author) {
		super();
		this.comment = comment;
		this.data = data;
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AuthorDto getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDto author) {
		this.author = author;
	}
	

}
