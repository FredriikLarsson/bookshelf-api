package com.myBookshelfapi.book;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.myBookshelfapi.topic.Topic;


@Entity
public class Book {
	
	@Id
	private String isbn;
	private String title;
	private String author;
	//Bokens publiceringsdatum
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date pubdate;
	@ManyToOne
	@JoinColumn(name="topic_id")
	private Topic topic;

	public Book() {
		
	}
	
	public Book(String isbn, String title, String author, Date pubdate) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.pubdate = pubdate;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

}
