package com.learnit.operations.collectionsmylist;

import java.util.Iterator;

interface ListIterator<T> extends Iterator<T> {

	boolean hasPrevious();

	T previous();

	void set(T e);

	void remove();
}
