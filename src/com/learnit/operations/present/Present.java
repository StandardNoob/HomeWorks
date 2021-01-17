package com.learnit.operations.present;

import java.util.Arrays;

public class Present {

	private Sweet[] sweets;
	private int SWEETS_SIZE = 10;
	private int lastIndexOf;

	{
		sweets = new Sweet[SWEETS_SIZE];
	}

	public Sweet[] filterSweetsBySugarRange(double minSugarWeight, double maxSugarWeight) {
		return Arrays.stream(sweets).filter(sweet -> sweet != null && sweet.getSugarWeight() >= minSugarWeight
				&& sweet.getSugarWeight() <= maxSugarWeight).toArray(Sweet[]::new);
	}

	public double calculateTotalWeight() {
		return Arrays.stream(sweets).mapToDouble(sweet -> sweet.getWeight()).sum();
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
		return Arrays.stream(sweets).filter(sweet -> sweet != null).toArray(Sweet[]::new);
	}
}
