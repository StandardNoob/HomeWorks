package com.learnit.operations.methods;

import java.util.Scanner;

public class Method9 {

	public static void main(String[] args) {

		String s = "Login;Name;Email\r\n" + "peterson;Chris Peterson;peterson@outlook.com\r\n"
				+ "james;Derek James;james@gmail.com\r\n" + "jackson;Walter Jackson;jackson@gmail.com\r\n"
				+ "gregory;Mike Gregory;gregory@yahoo.com\r\n" + "";
		System.out.println(convert1(s));
		System.out.println(convert2(s));

	}

	public static String convert1(String input) {
		String[] s = input.split("\\r\\n");
		String result = "";
		for (int i = 0; i < s.length; i++) {
			String[] line = s[i].split(";");
			result += line[0] + " ==> " + line[2] + "\n";
		}

		return result;
	}

	public static String convert2(String input) {
		String[] s = input.split("\\r\\n");
		String result = "";
		for (int i = 0; i < s.length; i++) {
			String[] line = s[i].split(";");
			result += line[1] + " (email: " + line[2] + ")" + "\n";
		}

		return result;

	}
}
