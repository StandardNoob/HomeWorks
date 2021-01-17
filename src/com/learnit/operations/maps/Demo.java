package com.learnit.operations.maps;

import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		DefaultLruCache defaultLruCache = new DefaultLruCache(3);
		defaultLruCache.put(1, 1);
		defaultLruCache.put(2, 2);
		defaultLruCache.put(3, 3);

		for (Map.Entry<Integer, Integer> keyValue : defaultLruCache.entrySet()) {
			System.out.println("Key: " + keyValue.getKey() + ", Value: " + keyValue.getValue());
		}
		defaultLruCache.get(1);
		defaultLruCache.get(1);
		defaultLruCache.get(1);
		defaultLruCache.get(3);
		defaultLruCache.get(3);
		defaultLruCache.put(4, 4);

		System.out.println();

		for (Map.Entry<Integer, Integer> keyValue : defaultLruCache.entrySet()) {
			System.out.println("Key: " + keyValue.getKey() + ", Value: " + keyValue.getValue());
		}
	}

}
