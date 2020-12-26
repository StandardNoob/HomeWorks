package com.itbulls.learnit.riabchenko.operations.loop;

import java.util.Scanner;

public class Loops3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the height of the pyramid: ");
		int h = sc.nextInt();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = h; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
