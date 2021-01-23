package com.learnit.operations.multithreading.max;

import java.util.Arrays;
import java.util.List;

public class ArrMaxInt implements Runnable {

	private int[] row;

	private List<Integer> list;

	public ArrMaxInt(int[] row, List<Integer> list) {
		this.row = row;
		this.list = list;
	}

	public int[] getRow() {
		return row;
	}

	public void setRow(int[] row) {
		this.row = row;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public static int maxInt(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}

	@Override
	public void run() {
		list.add(maxInt(row));

	}

}
