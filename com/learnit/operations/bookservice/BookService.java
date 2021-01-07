package com.learnit.operations.bookservice;

import java.util.ArrayList;
import java.util.Arrays;

public class BookService {

	public Book[] filterBooksByAuthor(Author author, Book[] books) {
		ArrayList<Book> bookArray = new ArrayList<>();
		for (Book book : books) {
			if (book != null && book.getAuthors().equals(author)) {
				bookArray.add(book);
			}
		}
		Book[] resultArrayOfBookByAuthor = bookArray.toArray(Book[]::new);
		return resultArrayOfBookByAuthor;
	}

	public Book[] filterBooksByPublisher(Publisher publisher, Book[] books) {
		ArrayList<Book> bookArray = new ArrayList<>();
		for (Book book : books) {
			if (book != null && book.getPublisher().equals(publisher)) {
				bookArray.add(book);
			}
		}

		Book[] resultArrayOfBookByPublisher = bookArray.toArray(Book[]::new);
		return resultArrayOfBookByPublisher;
	}

	public Book[] filterBooksAfterSpecifiedYear(int yearFromInclusively, Book[] books) {
		ArrayList<Book> bookArray = new ArrayList<>();
		for (Book book : books) {
			if (book != null && book.getPublishingYear() >= yearFromInclusively) {
				bookArray.add(book);
			}
		}
		Book[] resultArrayOfBookAfterSpecifiedYear = bookArray.toArray(Book[]::new);
		return resultArrayOfBookAfterSpecifiedYear;
	}

}
