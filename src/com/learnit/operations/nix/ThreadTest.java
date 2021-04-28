package com.learnit.operations.nix;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
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
		System.out.println(Thread.currentThread().getName());
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}).start();
		

	}

}
