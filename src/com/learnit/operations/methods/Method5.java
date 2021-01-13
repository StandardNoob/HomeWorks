package com.learnit.operations.methods;

import java.util.Scanner;

public class Method5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Specify matrix size:");
		int size = Integer.valueOf(sc.next());
		double[][] matrix = createMatrix(size);
		System.out.println("This is your MATRIX: ");
		printMatrix(matrix);
		System.out.println();
		System.out.println("How much do you want to rotate the matrix?    \r\n"
				+ "- Press 1 to rotate matrix to 90 degrees\r\n" + "- Press 2 to rotate matrix to 180 degrees\r\n"
				+ "- Press 3 to rotate matrix to 270 degrees");
		int rotation = Integer.valueOf(sc.next());

		switch (rotation) {
		case 1:
			rotate90(matrix);
			break;
		case 2:
			rotate180(matrix);
			break;
		case 3:
			rotate270(matrix);
			break;
		default:
			System.out.println("You have selected an option that does not exist!");
		}
	}

	public static void rotate90(double[][] matrix) {
		double[][] matrix90 = rotateMatrix90(matrix);
		printMatrix(matrix90);
	}

	public static void rotate180(double[][] matrix) {
		double[][] matrix90 = rotateMatrix90(matrix);
		double[][] matrix180 = rotateMatrix90(matrix90);
		printMatrix(matrix180);
	}

	public static void rotate270(double[][] matrix) {
		double[][] matrix90 = rotateMatrix90(matrix);
		double[][] matrix180 = rotateMatrix90(matrix90);
		double[][] matrix270 = rotateMatrix90(matrix180);
		printMatrix(matrix270);
	}

	private static double[][] createMatrix(int size) {
		double[][] matrix = new double[size][size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = Double.valueOf(Integer.toString(i) + "." + Integer.toString(j));
			}
		}
		return matrix;
	}

	public static void printMatrix(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static double[][] rotateMatrix90(double[][] matrix) {
		int side = matrix.length;
		double[][] matrix90 = new double[side][side];
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				matrix90[i][j] = matrix[side - j - 1][i];
			}
		}
		return matrix90;
	}
}
