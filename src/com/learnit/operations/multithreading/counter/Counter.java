package com.learnit.operations.multithreading.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Counter implements Runnable {

	private static int firstCounter;
	private static int secondCounter;

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		IntStream.range(0, 100).forEach(i -> executor.submit(Counter::counterMethod));
		stopExecuror(executor);
	}

	// delete synchronized to test
	public static synchronized void counterMethod() {
		String result = firstCounter > secondCounter ? "firstCounter is biggest" : "secondCounter is biggest";
		if (firstCounter == secondCounter) {
			result = "Counters are equal!";
		}
		System.out.println(result);
		firstCounter++;
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		secondCounter++;
	}

	@Override
	public void run() {

	}

	public static void stopExecuror(ExecutorService executor) {
		try {
			executor.shutdown();
			executor.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("termination interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("killing non-finished tasks");
			}
			executor.shutdownNow();
		}
	}

}
