package com.myBookshelfapi.book;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myBookshelfapi.topic.Topic;

@Entity
public class Book {
	
	@Id
	private String isbn;
	private String titel;
	private String author;
	//Bokens publiceringsdatum
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date pubDate;
	@ManyToOne
	private Topic topic;

	public Book() {
		
	}
	
	public Book(String isbn, String titel, String author, Date pubDate, String topicId) {
		this.isbn = isbn;
		this.titel = titel;
		this.author = author;
		this.pubDate = pubDate;
		this.topic = new Topic(topicId, "");
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

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

}
