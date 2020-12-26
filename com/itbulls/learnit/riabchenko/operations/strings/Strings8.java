package com.itbulls.learnit.riabchenko.operations.strings;

import java.util.Scanner;

public class Strings8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your text: ");
		String text = sc.nextLine();
		String[] textArr = text.split("[\\p{Punct}\\s]+");

		for (String words : textArr) {
			System.out.println(words);
		}
	}
}
