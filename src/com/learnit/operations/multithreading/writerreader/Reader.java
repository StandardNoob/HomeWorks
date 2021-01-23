package com.learnit.operations.multithreading.writerreader;

public class Reader implements Runnable {

	private Buffer text;

	public Reader(Buffer text) {
		this.text = text;
	}

	public void read() {
		System.out.println(Thread.currentThread().getName() + " read from the buffer: " + text.getText());
	}

	@Override
	public void run() {
		synchronized (text) {
			try {
				read();
				text.wait();
			} catch (InterruptedException e) {
				System.out.println("You in a Reader EXEPTION Block!");
			}
		}
	}
}
