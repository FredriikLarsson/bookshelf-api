package com.myBookshelfapi.book;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
	
	public ArrayList<Book> findByTopicId(String topicId);
	
}
