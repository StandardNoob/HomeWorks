package com.learnit.operations.methods;

public class Palindrom {

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaa";
		char[] chars = s.toCharArray();
		boolean isPalindrom = true;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != chars[chars.length-1-i]) {
				isPalindrom = false;
			}
		}
		System.out.println(isPalindrom);

	}

}
