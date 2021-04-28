package com.learnit.operations.nix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;





public class MapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("first", 1);
		map.put("second", 2);
		map.put("fird", 3);
//		for (Map.Entry<String, Integer> entry : map.entrySet()) {
//			System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
//			
//		}		
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(string);
		}
//		System.out.println(map.get("first"));
	}

}
