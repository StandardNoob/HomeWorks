package com.learnit.operations.nix;

public class Palindrom {
	public static void main(String[] args) {
		String s = "123456789987654321";
		System.out.println(isPalindromCheck(s));
		System.out.println(isPalindromCheck2(s));
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
	public static boolean isPalindromCheck2(String str) {		
		return str.equals(new StringBuilder(str).reverse().toString()) ? true : false;
	}
}
