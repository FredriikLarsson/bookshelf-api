package com.myBookshelfapi.book;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookshelfapi.topic.Topic;


@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	/*
	 * Hämta alla böcker inom ett ämne
	 * @param topicId = ämnets primärnyckel (ämnets namn)
	 * @return en lista med alla böcker inom ämnet
	 */
	public ArrayList<Book> getAllBooks(String topicId) {
		ArrayList<Book> books = new ArrayList<Book>();
		bookRepository.findByTopicTopicId(topicId).forEach(t -> books.add(t));
		return books;
	}
	
	/*
	 * Lägger till en bok till ett ämne
	 * @param topicId = ämnets primärnyckel (ämnets namn),
	 * @param book = boken som ska läggas till i ämnet
	 */
	public void addBook(String topicId, Book book) {
		book.setTopic(new Topic(topicId, ""));
		bookRepository.save(book);
	}

	/*
	 * Hämtar en specifik bok
	 * @param bookId = bokens primärnyckel (ISBN nummer)
	 * @return den specifika boken
	 */
	public Optional<Book> getBook(String bookId) {
		return bookRepository.findById(bookId);
	}

	/*
	 * Uppdaterar en befintlig bok
	 * @param book = den nya boken som ska ersätta den gamla
	 * @param bookIsbn = den gamla bokens isbn nummer
	 * @param topicId = den gamla bokens ämnes Id
	 */
	public void updateBook(String bookIsbn, Book book, String topicId) {
		if (bookRepository.findById(bookIsbn).isPresent()) {
			book.setTopic(new Topic(topicId, ""));
			book.setIsbn(bookIsbn);
			bookRepository.save(book);
		}
	}

	/*
	 * Tar bort en specifik bok
	 * @param bookIsbn = bokens isbn nummer
	 */
	public void deleteBook(String bookIsbn) {
		bookRepository.deleteById(bookIsbn);
	}
	
}
