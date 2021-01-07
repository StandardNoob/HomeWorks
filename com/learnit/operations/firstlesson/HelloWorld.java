package com.learnit.operations.firstlesson;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		int [] arr = new int [10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int)(Math.random()*100)+100;
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
