package com.learnit.operations.nix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Coll {

	public static void main(String[] args) {
		/*
		 * Collection:List, Set, Queue;
		 * List - LinkedList, ArrayList, Vector;
		 * Set - HashSet, TreeSet, LinkedHashSet;
		 * Queue - LinkedList, PriorityQueue; FIFO
		 * Map - HashTable, HashMap, TreeMap, LInkedHashMap;
		 */
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
				list.add(random.nextInt(100));
				list.add(random.nextInt(100));
				list.add(random.nextInt(100));
				list.add(random.nextInt(100));
				list.stream().forEach(System.out::println);
				List<Integer> copyList = new ArrayList<Integer>(list);						
				System.out.println("__");
				copyList.stream().forEach(System.out::println);
	}
}
