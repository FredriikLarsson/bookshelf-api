package com.myBookshelfapi.topic;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Topic {
	
	//Ämnets namn
	@Id
	private String topicId;
	//Beskrivningen över ämnet
	private String description;
	
	public Topic() {
		
	}
	
	public Topic(String topicId, String description) {
		this.topicId = topicId;
		this.description = description;
	}
	
	public String getId() {
		return topicId;
	}
	public void setId(String topicId) {
		this.topicId = topicId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
