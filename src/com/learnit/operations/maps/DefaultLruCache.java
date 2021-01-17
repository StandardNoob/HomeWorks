package com.learnit.operations.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultLruCache extends LinkedHashMap<Integer, Integer> implements LruCache {

	private int capacity;

	public DefaultLruCache(int capacity) {
		super(16, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		if (super.size() > this.capacity) {
			return true;
		}
		return false;
	}

	@Override
	public int get(int key) {
		if (super.containsKey(key)) {
			return super.get(key);
		}
		return -1;
	}

	@Override
	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
