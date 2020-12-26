package com.itbulls.learnit.riabchenko.operations.methods;

import java.util.Scanner;

public class Method8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number:");
		int n = Integer.valueOf(sc.next());
		int result = sumDigitsInPositiveNumber(n);
		System.out.println(result);

	}

	public static int sumDigitsInPositiveNumber(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number = number / 10;
		}
		return sum;
	}

}
