package com.learnit.operations.firstlesson;

import java.util.Scanner;

public class AreaCalculatorForTriangle {

	public static void main(String[] args) {
		areaŅalculation();
	}

	static void areaŅalculation() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter length of the side A of triangle:");
			double a = Double.parseDouble(sc.next());
			System.out.println("Enter length of the side B of triangle:");
			double b = Double.parseDouble(sc.next());
			System.out.println("Enter length of the side C of triangle:");
			double c = Double.parseDouble(sc.next());
			double p = (a + b + c) / 2;
			System.out.println(
					(a + b > c && a + c > b && b + c > a) ? Math.sqrt(p * (p - a) * (p - b) * (p - c)) : "NaN");
		} catch (Exception e) {
			System.out.println("You entered incorrect data! Please enter the number!");
			areaŅalculation();
		}

	}

}
