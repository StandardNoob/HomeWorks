package com.learnit.operations.methods;

import java.util.Scanner;

public class Method7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two numbers separated by space:");
		String s = sc.nextLine();
		String[] sArr = s.split("\\s");
		int firstInt = Integer.valueOf(sArr[0]);
		int secondInt = Integer.valueOf(sArr[1]);
		int result = gcdRecursive(firstInt, secondInt);
		System.out.println(result);

	}

	public static int gcdRecursive(int firstNumber, int secondNumber) {
		if (secondNumber == 0) {
			return Math.abs(firstNumber);
		} else {
			return gcdRecursive(secondNumber, firstNumber % secondNumber);
		}
	}
}
