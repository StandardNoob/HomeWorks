package com.learnit.operations.collectionsmylist;

public interface MyList<T> extends Iterable<T> {
	void add(T e);

	void clear();

	boolean remove(T o);

	T[] toArray();

	T get(int index);

	int size();

	boolean contains(T o);

	boolean containsAll(MyList<T> c);
}
