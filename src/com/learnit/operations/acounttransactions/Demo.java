package com.learnit.operations.acounttransactions;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		Account accountFrom = new Account(111);
		Account accountTo = new Account(222);

		accountFrom.sendMoneyToAccount(accountTo, 10000);
		accountFrom.withdrawMoney(10000);

		System.out.println(Arrays.toString(accountFrom.getTransactions()));
		System.out.println(Arrays.toString(accountTo.getTransactions()));

	}

}
