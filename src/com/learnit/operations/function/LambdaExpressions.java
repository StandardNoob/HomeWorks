package com.learnit.operations.function;

import java.util.Arrays;
import java.util.Scanner;

public class LambdaExpressions {

	public static void main(String[] args) {
		System.out.println("Enter words separated by space: ");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		String[] strings = userInput.split("\\s");
		Arrays.sort(strings, LambdaExpressions::compareStrings);
//		 Arrays.sort(strings, (s1,s2) -> s2.length() - s1.length());

		for (String string : strings) {
			System.out.print(string + " ");
		}
	}

	private static int compareStrings(String s1, String s2) {
		int compareResult = s2.length() - s1.length();
		if (compareResult == 0) {
			compareResult = s1.compareToIgnoreCase(s2);
		}
		return compareResult;
	}
}
