package com.learnit.operations.collections;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		
		DefaultMyList myDemoList = new DefaultMyList();
		
		myDemoList.add("1");
		myDemoList.add("2");
		myDemoList.add("3");
		myDemoList.add("4");
		myDemoList.add("5");
		System.out.println("Start myDemoList: " + myDemoList);

		myDemoList.remove("3");
		System.out.println("myDemoList after remove \"3\" : " + myDemoList);

		Object[] arr = myDemoList.toArray();
		System.out.println("myDemoList toArray: " + Arrays.toString(arr));

		System.out.println("myDemoList size: " + myDemoList.size());

		System.out.println("myDemoList contains \"2\": " + myDemoList.contains("2"));
		System.out.println("myDemoList contains \"3\": " + myDemoList.contains("3"));

		DefaultMyList myDemoList2 = new DefaultMyList();
		myDemoList2.add("4");
		myDemoList2.add("5");
		System.out.println("myDemoList containsAll: " + myDemoList.containsAll(myDemoList2));

		myDemoList.clear();
		System.out.println("myDemoList clear: " + myDemoList);
	}
}
