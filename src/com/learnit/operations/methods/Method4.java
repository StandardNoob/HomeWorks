package com.learnit.operations.methods;

import java.util.Scanner;

public class Method4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter random words separated by space:");
		String s = sc.nextLine();
		String[] enteredWords = s.split("\\s");
		System.out.println("Enter minimum length of string to filter words which were entered:");
		int minimumLength = Integer.valueOf(sc.next());
		String[] newArr = filterWordsByLength(minimumLength, enteredWords);
		for (String string : newArr) {
			System.out.println(string);
		}
	}

	public static String[] filterWordsByLength(int minLength, String[] words) {
		String newStr = "";
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() >= minLength) {
				newStr += words[i] + ";";
			}
		}
		String[] newArr = newStr.split(";");		
		return newArr;
	}

}
