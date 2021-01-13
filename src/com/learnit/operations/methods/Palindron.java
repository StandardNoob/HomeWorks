package com.learnit.operations.methods;

public class Palindron {

	public static void main(String[] args) {
		String s = "1236321";
		System.out.println(isPalindromCheck(s));
	}

	public static boolean isPalindromCheck(String str) {
		boolean isPalindrom = true;
		char[] chr = str.toCharArray();
		for (int i = 0; i < chr.length; i++) {
			if (chr[i] != chr[chr.length - 1 - i]) {
				isPalindrom = false;
			}
		}
		return isPalindrom;
	}
}
