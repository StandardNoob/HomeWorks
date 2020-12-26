package com.itbulls.learnit.riabchenko.operations.hw1and2;

import java.util.Scanner;

public class —alculator—ircle—ircumference {

	public static void main(String[] args) {
		calculate—ircle—ircumference();
	}

	static void calculate—ircle—ircumference() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter circle radius: ");
		try {
			double r = Double.parseDouble(sc.next());
			System.out.println("Circle circumference = " + (2 * Math.PI * r));
		} catch (NumberFormatException e) {
			System.out.println("You entered incorrect data! Please enter the number!");
			calculate—ircle—ircumference();
		}
	}

}
