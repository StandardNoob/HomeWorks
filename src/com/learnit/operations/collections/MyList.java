package com.learnit.operations.collections;

public interface MyList {
	void add(Object e);

	void clear();

	boolean remove(Object o);

	Object[] toArray();

	Object get(int index);

	int size();

	boolean contains(Object o);

	boolean containsAll(MyList c);
}
