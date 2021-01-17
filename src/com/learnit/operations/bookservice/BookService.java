package com.learnit.operations.bookservice;

import java.util.Arrays;

public class BookService {
	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		return Arrays.stream(books).filter(book -> book.getAuthors().equals(author)).toArray(Book[]::new);
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		return Arrays.stream(books).filter(book -> book.getPublisher().equals(publisher)).toArray(Book[]::new);
	}

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		return Arrays.stream(books).filter(book -> book.getPublishingYear() == yearFromInclusively).toArray(Book[]::new);
	}
}
