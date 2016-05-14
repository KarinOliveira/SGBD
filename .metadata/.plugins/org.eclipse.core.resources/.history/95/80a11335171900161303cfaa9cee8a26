package controller;

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import enumeration.TransactionStates;
import events.TransactionBegin;
import model.Transaction;

public class TransactionManager {
	
	private ArrayList<Transaction> transactions;
	
	public TransactionManager() {
		this.transactions = new ArrayList<>();
	}
	
	public void createTransaction(String id) {
		Transaction newTransaction = new Transaction(id);
		
		TransactionBegin beginTransaction = new TransactionBegin();		
		beginTransaction.changeTransactionState(newTransaction);
				
		addNewTransaction(newTransaction);
	}
	
	public void showTransactions() {
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}
	
	private void addNewTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
}
