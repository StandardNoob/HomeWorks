package com.itbulls.learnit.riabchenko.operations.ifElse;

public class IfElse2 {
	public static void main(String[] args) {
		if (args.length > 1) {
			System.out.println("Please, select either 'ADMIN' or 'GUEST' mode for this program");
		}
		if (args.length == 1) {
			if (args[0].equals("--admin")) {
				System.out.println("Hello, Admin!");
			}
			if (args[0].equals("--guest")) {
				System.out.println("Hello, Guest!");
			}
		}
	}
}
