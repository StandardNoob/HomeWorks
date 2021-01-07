package com.learnit.operations.bookservice;

public class Publisher {
	private int id;
	private String publisherName;

	public Publisher() {
		super();
	}

	public Publisher(int id, String publisherName) {
		super();
		this.id = id;
		this.publisherName = publisherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	@Override
	public String toString() {
		return "Publisher ID= " + id + ", Publisher Name= " + publisherName;
	}
	

}
