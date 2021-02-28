package com.myBookshelfapi.book;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
	
	/*
	 * Hämta böcker som ligger inom ett specifikt ämne
	 * @param topicId = ämnets id (namn)
	 * @return lista med böcker inom ämnet
	 */
	public ArrayList<Book> findByTopicTopicId(String topicId);
	
}
