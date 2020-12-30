package com.itbulls.learnit.riabchenko.operations.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class Present {

	private Sweet[] sweets;
	private int SWEETS_SIZE = 10;
	private int lastIndexOf;

	{
		sweets = new Sweet[SWEETS_SIZE];
	}

	public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
		ArrayList<Sweet> filterSweet = new ArrayList<>();
		for (int i = 0; i < sweets.length; i++) {
			if (sweets[i].getSugarWeight() >= minSugarWeight && sweets[i].getSugarWeight() <= maxSugarWeight
					&& sweets[i] != null) {
				filterSweet.add(sweets[i]);
			}
		}
		Sweet[] filterSweetArr = (Sweet[]) filterSweet.toArray();
		return filterSweetArr;
	}

	public double calculateTotalWeight() {
		int totalWeight = 0;
		for (int i = 0; i < sweets.length; i++) {
			if (sweets[i] != null) {
				totalWeight += sweets[i].getWeight();
			}
		}
		return totalWeight;
	}

	public void addSweet(Sweet sweet) {
		if (sweet == null) {
			return;
		}
		if (sweets.length <= lastIndexOf) {
			sweets = Arrays.copyOf(sweets, sweets.length * 2);
		}
		sweets[lastIndexOf++] = sweet;
	}

	public Sweet[] getSweets() {
		ArrayList<Sweet> returnSweets = new ArrayList<>();
		for (int i = 0; i < sweets.length; i++) {
			if (sweets[i] != null) {
				returnSweets.add(sweets[i]);
			}
		}
		Sweet[] getSweetsArr = (Sweet[]) returnSweets.toArray();
		return getSweetsArr;
	}

}
