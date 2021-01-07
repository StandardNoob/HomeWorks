package com.learnit.operations.strings;

import java.util.Scanner;

public class Switch2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("  i.	login\r\n" + " ii.	sign_up\r\n" + "iii.	terminate_program\r\n"
				+ " iv.	main_menu\r\n" + "  v.	about_app\r\n" + "");
		System.out.println("Enter one of possible events:");

		String userInput = sc.next();
		switch (userInput) {

		case "login":
			System.out.println("Please, enter your username");
			break;
		case "sign_up":
			System.out.println("Welcome!");
			break;
		case "terminate_program":
			System.out.println("Thank you! Good bye!");
			break;
		case "main_menu":
			System.out.println("Main menu");
			break;
		case "about_app":
			System.out.println("This app is created by me with support of ®IT-Bulls.com");
			break;
		default:
			System.out.println(
					"Please, enter one of these values: login, sign_up, terminate_program, main_menu, about_app");
			break;
		}
	}
}
