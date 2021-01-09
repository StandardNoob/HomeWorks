package com.learnit.operations.methods;

import java.util.Scanner;

public class Method11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Select mode:" + System.lineSeparator()
				+ "i.  To convert from decimal to Roman number user should enter D2R" + System.lineSeparator()
				+ "ii. To convert from Roman number to decimal user should enter R2D");
		String userMode = sc.nextLine();
		System.out.println("Enter the Number:");
		String userInput = sc.nextLine();
		if (userMode.equalsIgnoreCase("D2R")) {
			fromDecimalToRomanNumber(userInput);
		}
		if (userMode.equalsIgnoreCase("R2D")) {
			fromRomanNumberToDecimal(userInput);
		}
	}

	public static void fromDecimalToRomanNumber(String userInput) {
		int n = Integer.parseInt(userInput);
		int units = n % 10;
		n = n / 10;
		String unitsResult = "";

		if (n >= 0 && units <= 3) {
			for (int i = 0; i < n; i++) {
				unitsResult += "I";
			}
		}
		
		if (n >= 4 && units <= 8) {
			unitsResult = "V";
			String st = "";
			for (int i = 0; i < Math.abs(units - 5); i++) {
				st += "I";
			}
			if (units > 5) {unitsResult = unitsResult + st;}
			if (units < 5) {unitsResult = st + unitsResult;}
		}
		
		if (units == 9) {unitsResult = "IX";}
		System.out.println(unitsResult);

	}

	public static void fromRomanNumberToDecimal(String userInput) {

	}

}
