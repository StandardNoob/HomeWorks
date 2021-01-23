package com.learnit.operations.multithreading.writerreader;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Writer implements Runnable {

	private Buffer text;

	public Writer(Buffer text) {
		this.text = text;
	}

	public void write() {
		System.out.println("You are a Writer - write your text and press ENTER: ");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		text.setText(userInput);
		System.out.println("The text added to the buffer!");
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
			synchronized (text) {
				write();
				text.notifyAll();
			}
		} catch (InterruptedException e) {
			System.out.println("You in a Writer EXEPTION Block!");
		}

	}
}
