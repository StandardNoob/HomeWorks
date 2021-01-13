package com.learnit.operations.controlstatements;

public class IfElse3 {
	// Run as -> Run configurations -> add 2 digit arguments
	public static void main(String[] args) {
		if (args[0].contains(".") || args[1].contains(".")) {
			double resultDouble = Double.parseDouble(args[0]) + Double.parseDouble(args[1]);
			System.out.println(resultDouble);
		} else {
			int resultInt = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
			System.out.println(resultInt);
		}
	}
}
