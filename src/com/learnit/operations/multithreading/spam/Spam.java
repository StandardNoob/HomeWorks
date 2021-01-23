package com.learnit.operations.multithreading.spam;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

public class Spam {

	private Vector<Long> listOfTime;
	private Vector<String> listOfMes;

	public Spam(Vector<Long> listOfTime, Vector<String> listOfMes) {		
		this.listOfTime = listOfTime;
		this.listOfMes = listOfMes;
	}

	public Vector<Long> getListOfTime() {
		return listOfTime;
	}

	public void setListOfTime(Vector<Long> listOfTime) {
		this.listOfTime = listOfTime;
	}

	public Vector<String> getListOfMes() {
		return listOfMes;
	}

	public void setListOfMes(Vector<String> listOfMes) {
		this.listOfMes = listOfMes;
	}

	public synchronized void printToConsol() {
		for (int i = 0; i < listOfTime.size(); i++) {
			System.out.println(listOfMes.get(i));
			try {
				TimeUnit.MILLISECONDS.sleep(listOfTime.get(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
