package com.itbulls.learnit.riabchenko.operations.methods;

import java.util.Arrays;
import java.util.Scanner;

public class Method6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of an array:");
		int arrLength = Integer.valueOf(sc.next());
		int[] arr1 = generateRandomArray(arrLength);
		int[] arr2 = extendArray(arr1);
		System.out.println(Arrays.toString(arr2));
	}

	public static int[] generateRandomArray(int amountOfElements) {
		int[] intArr = new int[amountOfElements];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int) (Math.random() * 100) + 1;
		}
		return intArr;
	}

	public static int[] extendArray(int[] arr) {
		int[] extendArray = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			extendArray[i] = arr[i];
		}
		for (int i = arr.length, g = 0; i < extendArray.length; i++, g++) {
			extendArray[i] = arr[g] * 2;
		}
		return extendArray;
	}
}
