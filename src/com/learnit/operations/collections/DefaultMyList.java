package com.learnit.operations.collections;

import java.util.Arrays;

public class DefaultMyList implements MyList {

	private final int DEFAULT_START_SIZE = 10;
	private Object[] list;
	private int lastIndexAdded;

	{
		list = new Object[DEFAULT_START_SIZE];
	}

	@Override
	public void add(Object e) {
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
		list = new Object[DEFAULT_START_SIZE];
	}

	@Override
	public boolean remove(Object o) {
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
	public Object[] toArray() {
		Object[] toArr = new Object[this.size()];
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
	public boolean contains(Object o) {
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
	public boolean containsAll(MyList c) {
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
	public Object get(int index) {
		return this.list[index];
	}
}
