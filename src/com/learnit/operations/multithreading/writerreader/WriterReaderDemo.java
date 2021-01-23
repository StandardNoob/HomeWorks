package com.learnit.operations.multithreading.writerreader;

public class WriterReaderDemo {

	public static void main(String[] args) throws InterruptedException {

		Buffer text = new Buffer("Start Messege for Buffer!");
		Writer writer = new Writer(text);

		for (int i = 0; i < 3; i++) {
			new Thread(new Reader(text), "Reader #1").start();
			new Thread(new Reader(text), "Reader #2").start();
			new Thread(new Reader(text), "Reader #3").start();
			writer.run();
		}
	}
}
