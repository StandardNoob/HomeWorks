package com.learnit.operations.firstlesson;

public class ACDC {
	public static void main(String[] args) {

		double acdc = Math.pow(16, 3) * 10 + Math.pow(16, 2) * 12 + Math.pow(16, 1) * 13 + Math.pow(16, 0) * 12;
		System.out.println(acdc);
		
		/*
		 * 1010110011011100 = 44252; 10 -- 1010 12 -- 1100 13 -- 1101 12 -- 1100
		 * System.out.println("ACDC = " + Integer.parseInt("1010110011011100", 2));
		 */

	}
}
