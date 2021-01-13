package com.learnit.operations.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		ArrayList<Object> list = new ArrayList<Object>(100000);
		list.trimToSize();
		
		LinkedList<Object> list2 = new LinkedList<Object>();
		list2.add(new Object());
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("1", "value");
		for (Map.Entry<String, String> object : map.entrySet()) {
			System.out.println(object.getKey());
			System.out.println(object.getValue());
		}

	}

}
