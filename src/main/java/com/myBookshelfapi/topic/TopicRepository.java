package com.myBookshelfapi.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Long> {
	
	/*
	 * Söker ett ämne "topic" på dess namn.
	 * @param name = namnet på ämnet
	 * @return ett specifikt ämne
	 */
	public Topic findByName(String name);
	
}
