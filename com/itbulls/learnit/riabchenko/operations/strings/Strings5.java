package com.itbulls.learnit.riabchenko.operations.strings;

import java.util.Formatter;

public class Strings5 {
	public static void main(String[] args) {
		Formatter formatter = new Formatter();

		for (int i = 1; i <= 5; i++) {
			String s = "%." + i + "f";
			formatter.format(s, Math.PI);
			System.out.println(formatter);
			formatter = new Formatter();
		}
	}
}
