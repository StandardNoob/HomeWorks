package com.learnit.operations.methods;

import java.util.Scanner;

public class Method2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input height of the rectangle:");
		int height = Integer.valueOf(sc.next());
		System.out.println("Input the width of the rectangle:");
		int width = Integer.valueOf(sc.next());
		drawRectangle(height, width);
	}

	public static void drawRectangle(int height, int width) {

		for (int i = 0; i < width; i++) {
			System.out.print("+");
		}
		System.out.println();
		for (int i = 0; i < height - 2; i++) {
			System.out.print("+");
			for (int j = 0; j < width - 2; j++) {
				System.out.print(" ");
			}
			System.out.print("+");
			System.out.println();
		}
		for (int i = 0; i < width; i++) {
			System.out.print("+");
		}
	}
}
