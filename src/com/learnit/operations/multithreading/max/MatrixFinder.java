package com.learnit.operations.multithreading.max;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MatrixFinder {

	public static void main(String[] args) throws InterruptedException {

		int[][] matrix = createMatrix(4, 100);
		List<Integer> listOfMax = new ArrayList<>();
		System.out.println("Main Thread MAX: " + maxIntFromMatrix(matrix));

		List<Thread> threads = new ArrayList<>();
		for (int row = 0; row < matrix.length; row++) {
			threads.add(new Thread(new ArrMaxInt(createArrFromMatrix(matrix, row), listOfMax)));
		}
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).start();
			threads.get(i).join();
		}
		System.out.println("Multithreadind MAX: " + Collections.max(listOfMax));
	}

	private static int[][] createMatrix(int rows, int columns) {
		Random random = new Random();
		int[][] matrix = new int[rows][columns];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt();
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

	public static int[] createArrFromMatrix(int[][] m, int row) {
		int[] arr = new int[m[row].length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = m[row][i];
		}
		return arr;

	}

	public static int maxIntFromMatrix(int[][] matrix) throws InterruptedException {
		int max = matrix[0][0];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
				TimeUnit.MILLISECONDS.sleep(1);
			}
		}
		return max;
	}

}
