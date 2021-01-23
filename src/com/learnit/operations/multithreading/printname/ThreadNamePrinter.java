package com.learnit.operations.multithreading.printname;

import java.util.concurrent.TimeUnit;

public class ThreadNamePrinter {

	public static void main(String[] args) throws InterruptedException {
		ThreadNamePrinter threadNamePrinter = new ThreadNamePrinter();
		Thread thread = new Thread(() -> {
			int stop = 0;
			while (stop != 1) {
				try {
					System.out.println(Thread.currentThread().getName());
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					stop = 1;
					System.out.println(Thread.currentThread().getName() + " IS STOPED!");
				}
			}
		}, "FIRST THREAD");
		thread.start();
		TimeUnit.SECONDS.sleep(5);
		thread.interrupt();
		ThreadNamePrinterVsRun runFrom = threadNamePrinter.new ThreadNamePrinterVsRun(5000, 500);
		Thread thread2 = new Thread(runFrom, "SECOND THREAD");
		thread2.start();
	}

	public class ThreadNamePrinterVsRun implements Runnable {

		private int seconds;
		private int delay;

		public ThreadNamePrinterVsRun(int seconds, int delay) {
			this.seconds = seconds;
			this.delay = delay;
		}

		@Override
		public void run() {
			int sum = 0;
			try {
				while (sum <= this.seconds) {
					System.out.println(Thread.currentThread().getName());
					TimeUnit.MILLISECONDS.sleep(this.delay);
					sum += this.delay;
				}
				System.out.println(Thread.currentThread().getName());

			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " IS STOPED!");
			}
		}
	}
}
