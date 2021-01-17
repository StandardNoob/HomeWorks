package com.learnit.operations.stream;

import java.util.Arrays;
import java.util.Scanner;

public class FilterWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter random words separated by space: ");
		String[] strings = sc.nextLine().split(" ");
		Arrays.stream(filterWordsByLength(3, strings)).forEach(System.out::println);

	}

	public static String[] filterWordsByLength(int minLength, String[] words) {
		return Arrays.stream(words).filter(word -> word.length() >= minLength).toArray(String[]::new);
	}

}
