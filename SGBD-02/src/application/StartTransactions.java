package application;

import controller.TransactionManager;
import enumeration.TransactionStates;
import model.Transaction;

public class StartTransactions {
	
	public static void main(String[] args) {
		TransactionManager mTransactionManager = new TransactionManager();
		
		mTransactionManager.createTransaction("T1");
		mTransactionManager.showTransactions();
	}
}
