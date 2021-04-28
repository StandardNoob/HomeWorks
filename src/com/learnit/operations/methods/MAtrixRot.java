package com.learnit.operations.methods;

import java.util.Random;

public class MAtrixRot {

	public static void main(String[] args) {
		int matrix[][] = new int[3][3];
		Random random = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt(100)+1;
			}
		}
		printMatrix(matrix);
		 int [][] matri2 = rotateMatrix90(matrix);
		System.out.println("_____________________________");
		printMatrix(matri2);
		

	}
	
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] rotateMatrix90(int[][] matrix) {
		int side = matrix.length;
		int[][] matrix90 = new int[side][side];
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				matrix90[i][j] = matrix[side - j - 1][i];
			}
		}
		return matrix90;
	}

}
