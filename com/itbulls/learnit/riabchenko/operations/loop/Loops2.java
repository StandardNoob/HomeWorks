package com.itbulls.learnit.riabchenko.operations.loop;

import java.util.Scanner;

public class Loops2 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the namber:");
		char[] chrArr = sc.next().toCharArray();

		for (char c : chrArr) {
			System.out.println(c);
		}
	}

}
