package com.myBookshelfapi.book;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	private String isbn;
	private String titel;
	private String author;
	private Date pubDate;
	
	public Book(String isbn, String titel, String author, Date pubDate) {
		this.isbn = isbn;
		this.titel = titel;
		this.author = author;
		this.pubDate = pubDate;
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