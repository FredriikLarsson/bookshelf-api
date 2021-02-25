package com.myBookshelfapi.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	
	//Ämnets namn
	@Id
	private String id;
	//Beskrivningen över ämnet
	private String description;
	
	public Topic() {
		
	}
	
	public Topic(String id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
