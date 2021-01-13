package com.learnit.operations.methods;

import java.util.Scanner;

public class Method10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text: ");
		String s = sc.nextLine();
		System.out.println(firstCharToTitleCase(s));
	}

	public static String firstCharToTitleCase(String string) {
		char[] chrArr = string.toLowerCase().toCharArray();
		chrArr[0] = Character.toUpperCase(chrArr[0]);
		for (int i = 0; i < chrArr.length; i++) {
			if (Character.isWhitespace(chrArr[i])) {
				chrArr[i+1] = Character.toUpperCase(chrArr[i+1]);
			}
		}
		return String.valueOf(chrArr);
	}
}
