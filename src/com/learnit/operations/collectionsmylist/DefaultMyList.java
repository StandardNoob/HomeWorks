package com.learnit.operations.collectionsmylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DefaultMyList<T> implements MyList<T>, ListIterable<T> {

	private final int DEFAULT_START_SIZE = 10;
	private T[] list;
	private int lastIndexAdded;

	{
		list = (T[]) new Object[DEFAULT_START_SIZE];
	}

	@Override
	public void add(T e) {
		if (list == null) {
			return;
		}
		if (list.length <= lastIndexAdded) {
			list = Arrays.copyOf(list, list.length * 2);
		}
		list[lastIndexAdded++] = e;
	}

	@Override
	public void clear() {
		list = (T[]) new Object[DEFAULT_START_SIZE];
		;
	}

	@Override
	public boolean remove(T o) {
		if (o == null) {
			return false;
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null && list[i].equals(o)) {
				list[i] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public T[] toArray() {
		T[] toArr = (T[]) new Object[this.size()];
		;
		for (int i = 0, j = 0; i < list.length; i++) {
			if (list[i] != null) {
				toArr[j] = list[i];
				j++;
			}
		}
		return toArr;
	}

	@Override
	public int size() {
		int sizeOf = 0;
		if (list == null) {
			return 0;
		}
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				sizeOf++;
			}
		}
		return sizeOf;
	}

	@Override
	public boolean contains(T o) {
		boolean isContain = false;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				if (list[i].equals(o)) {
					isContain = true;
					break;
				}
			}
		}
		return isContain;
	}

	@Override
	public boolean containsAll(MyList<T> c) {
		if (c == null) {
			return false;
		}
		for (int i = 0; i < c.size(); i++) {
			if (!this.contains(c.get(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for (int i = 0; i < this.list.length; i++) {
			if (list[i] != null) {
				sb.append("[").append(list[i].toString()).append("]");
			}
		}
		sb.append("}");
		return sb.toString();
	}

	@Override
	public T get(int index) {
		return this.list[index];
	}

	@Override
	public Iterator<T> iterator() {
		return new IteratorImpl<>();
	}

	private class IteratorImpl<T> implements Iterator<T> {

		int cursor = 0;
		int lastRet = -1;

		@Override
		public boolean hasNext() {
			return cursor != size();

		}

		@Override
		public T next() {
			T next = (T) get(cursor);
			if (next == null) {
				throw new NoSuchElementException();
			}
			lastRet = cursor;
			cursor += 1;
			return next;
		}

		@Override
		public void remove() {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			DefaultMyList.this.remove(list[lastRet]);
			if (lastRet < cursor) {
				cursor--;
			}
			lastRet = -1;
		}
	}

	@Override
	public ListIterator<T> listIterator() {
		return new ListIteratorImpl<T>();
	}

	private class ListIteratorImpl<T> extends IteratorImpl<T> implements ListIterator<T> {

		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public T previous() {
			cursor -= 1;
			T previous = (T) get(cursor);
			if (previous == null) {
				cursor = 0;
				throw new NoSuchElementException();
			}
			lastRet = cursor;
			return previous;
		}

		@Override
		public void set(T e) {
			if (lastRet < 0) {
				throw new IllegalStateException();
			}
			T t = (T) list[lastRet];
			t = e;
			lastRet = -1;
		}
	}
}
