package com.itbulls.learnit.riabchenko.operations.enumhw;

import java.util.Scanner;

public class EnumDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mess = "";
		while (!(mess.equals("A") || mess.equals("B") || mess.equals("C") || mess.equals("D"))) {
			System.out.println("Enter message type (Only ‘A’, ‘B’, ‘C’ or ‘D’ message types are allowed.)");
			mess = sc.nextLine();
		}
		MessageType messageType = MessageType.valueOf(mess);
		System.out.println(messageType.getPriority());

	}

}
