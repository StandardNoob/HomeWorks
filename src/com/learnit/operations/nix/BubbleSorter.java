package com.learnit.operations.nix;

import java.util.Arrays;

public class BubbleSorter {

	public static void main(String[] args) {
		int arr[] = {1,8,5,9};
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}

	public static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = array.length - 1; j > i; j--) {
				if (array[j - 1] > array[j]) {
					int tmp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}
}
