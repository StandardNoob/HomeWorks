package com.itbulls.learnit.riabchenko.operations.innernestedClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
	private int id;
	private Transaction[] transactions;
	private int SIZE_OF_TRANSACTION_ARR = 10;

	{
		transactions = new Transaction[SIZE_OF_TRANSACTION_ARR];
	}

	public Account() {

	}

	public Account(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transaction[] getTransactions() {
		List<Transaction> arr = Arrays.asList(transactions);
		ArrayList<Transaction> listOfTransaction = new ArrayList<>(arr);
		for (Transaction transaction : transactions) {
			if (transaction != null) {
				listOfTransaction.add(transaction);
			}
		}
		Transaction[] transactionResult = listOfTransaction.toArray(Transaction[]::new);
		return transactionResult;
	}

	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}

	public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
		if (accountTo == null) {
			return;
		}
		if (moneyAmount <= 0) {
			return;
		}
		Transaction transaction = new Transaction(this, accountTo, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_SEND);
		addTransaction(transaction);
		accountTo.receiveMoney(this, moneyAmount);
	}

	public void withdrawMoney(double moneyAmount) {
		Transaction transaction = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
		addTransaction(transaction);
	}

	private void receiveMoney(Account accountFrom, double moneyAmount) {
		if (accountFrom == null) {
			return;
		}
		if (moneyAmount <= 0) {
			return;
		}
		Transaction transaction = new Transaction(accountFrom, this, moneyAmount,
				StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
		addTransaction(transaction);

	}

	private void addTransaction(Transaction transaction) {
		List<Transaction> arr = Arrays.asList(transactions);
		ArrayList<Transaction> listOfTransaction = new ArrayList<>(arr);
		if (transaction == null) {
			return;
		}
		listOfTransaction.add(transaction);
		transactions = listOfTransaction.toArray(Transaction[]::new);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + "]";
	}

	public class Transaction {
		private Account accountFrom;
		private Account accountTo;
		private double moneyAmount;
		private StandardAccountOperations operation;

		public Transaction() {

		}

		public Transaction(Account accountFrom, Account accountTo, double moneyAmount,
				StandardAccountOperations operation) {
			super();
			this.accountFrom = accountFrom;
			this.accountTo = accountTo;
			this.moneyAmount = moneyAmount;
			this.operation = operation;
		}

		public Account getAccountFrom() {
			return accountFrom;
		}

		public void setAccountFrom(Account accountFrom) {
			this.accountFrom = accountFrom;
		}

		public Account getAccountTo() {
			return accountTo;
		}

		public void setAccountTo(Account accountTo) {
			this.accountTo = accountTo;
		}

		public double getMoneyAmount() {
			return moneyAmount;
		}

		public void setMoneyAmount(double moneyAmount) {
			this.moneyAmount = moneyAmount;
		}

		public StandardAccountOperations getOperation() {
			return operation;
		}

		public void setOperation(StandardAccountOperations operation) {
			this.operation = operation;
		}

		@Override
		public String toString() {
			return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo + ", moneyAmount="
					+ moneyAmount + ", operation=" + operation + "]";
		}

	}
}
