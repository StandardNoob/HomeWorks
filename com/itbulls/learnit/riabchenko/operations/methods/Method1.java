package com.itbulls.learnit.riabchenko.operations.methods;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Method1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input integer numbers separated by space: ");
		String[] numbers = sc.nextLine().split("\\s");
		int[] intNumbers = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			intNumbers[i] = Integer.valueOf((numbers[i]));
		}
		int maxInt = findMaxIntInArray(intNumbers);
		System.out.println(maxInt);

	}

	public static int findMaxIntInArray(int[] intArray) {
		Arrays.sort(intArray);
		return intArray[intArray.length - 1];
	}

}
