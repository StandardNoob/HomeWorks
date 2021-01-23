
package com.learnit.operations.multithreading.spam;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class SpamDemo {
	private static boolean infinity = true;

	public static void main(String[] args) throws AWTException, InterruptedException {

		Vector<Long> timePeriod = new Vector<>(Arrays.asList(500l, 700l, 700l, 550l, 600l));
		Vector<String> spamMessege = new Vector<>(Arrays.asList("Spam Messege 1", "Spam Messege 2", "Spam Messege 3",
				"Spam Messege 4", "Spam Messege 5"));
		Spam spam = new Spam(timePeriod, spamMessege);

		Thread thread = new Thread(() -> {
			while (infinity) {
				spam.printToConsol();
			}
		});
		thread.start();
		TimeUnit.SECONDS.sleep(5);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		infinity = false;

	}

}
