package com.learnit.operations.firstlesson;

import java.util.Scanner;

public class ĐalculatorĐircleĐircumference {

	public static void main(String[] args) {
		calculateĐircleĐircumference();
	}

	static void calculateĐircleĐircumference() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter circle radius: ");
		try {
			double r = Double.parseDouble(sc.next());
			System.out.println("Circle circumference = " + (2 * Math.PI * r));
		} catch (NumberFormatException e) {
			System.out.println("You entered incorrect data! Please enter the number!");
			calculateĐircleĐircumference();
		}
	}

}
