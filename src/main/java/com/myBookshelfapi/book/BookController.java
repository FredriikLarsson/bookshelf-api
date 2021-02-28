package com.myBookshelfapi.book;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	/*
	 * Hämtar alla böcker inom ett specifikt ämne
	 * @param topicId = ämnets primärnyckel (namn på ämnet)
	 * @return en lista med böckerna i ett specifikt ämne
	 */
	@RequestMapping("/topics/{topicId}/books")
	public ArrayList<Book> getAllBooks(@PathVariable String topicId) {
		return bookService.getAllBooks(topicId);
	}
	
	/*
	 * Hämtar en specifik bok
	 * @param bookId = bokens primärnyckel
	 * @return den specifika boken
	 */
	@RequestMapping("/topics/{topicId}/books/{bookId}")
	public Optional<Book> getBook(@PathVariable String bookId) {
		return bookService.getBook(bookId);
	}
	
	/*
	 * Lägger till en bok till ett specifikt ämne
	 * @param topicId = ämnets primärnyckel (namn på ämnet),
	 * @param book = boken som ska läggas till
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/books")
	public void addBook(@PathVariable String topicId, @RequestBody Book book) {
		bookService.addBook(topicId, book);
	}
	
	/*
	 * Uppdaterar en befintlig book
	 * @param book = den nya boken som ska ersätta den gamla
	 * @param bookIsbn = den gamla bokens isbn nummer
	 * @param topicId = den gamla bokens ämnes Id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/books/{bookIsbn}")
	public void updateBook(@RequestBody Book book, @PathVariable String bookIsbn, @PathVariable String topicId) {
		bookService.updateBook(bookIsbn, book, topicId);
	}
	
	/*
	 * Tar bort en specifik bok
	 * @param bookIsbn = bokens isbn nummer
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/books/{bookIsbn}")
	public void deleteBook(@PathVariable String bookIsbn) {
		bookService.deleteBook(bookIsbn);
	}
	
}
