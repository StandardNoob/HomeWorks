package com.learnit.operations.nix;

import java.util.Random;

public class MatrixRot {

	public static void main(String[] args) {
		int[][] matrix = generateMatrix(10, 10);
		printMatrix(matrix);
		int[][] matrix2 = rotateMatrix90(matrix);
		System.out.println();
		printMatrix(matrix2);

	}

	public static int[][] generateMatrix(int rows, int columns) {
		int[][] matrix = new int[rows][columns];
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(90) + 10;
			}
		}
		return matrix;
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	// поворот матрицы ПО часовой стрелки.
	public static int[][] rotateMatrix90(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0][0];

		int rows = matrix.length, cols = matrix[0].length;
		int[][] result = new int[cols][rows];

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < rows; col++) {
				result[row][col] = matrix[cols - col - 1][row];
			}
		}
		return result;
	}

	// поворот матрицы ПРОТИВ часовой стрелки.
	public static int[][] reverseMatrix90(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0][0];

		int rows = matrix.length, cols = matrix[0].length;
		int[][] result = new int[cols][rows];

		for (int row = 0; row < cols; row++) {
			for (int col = 0; col < rows; col++) {
				result[row][col] = matrix[col][rows - row - 1];
			}
		}
		return result;
	}

}
