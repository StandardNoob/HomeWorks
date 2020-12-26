package com.itbulls.learnit.riabchenko.operations.methods;

import java.util.Scanner;

public class Method3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text:");
		String s = sc.nextLine();
		int amount = getWordsAmount(s);
		System.out.println(amount);

	}

	public static int getWordsAmount(String text) {
		String[] wordArr = text.split("[\\p{Punct}\\s&&[^-]]+");
		return wordArr.length;
	}

}
