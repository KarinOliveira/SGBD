package interfaces;

import model.Transaction;

public interface ChangeTransactionState {
	
	public void changeTransactionState(Transaction transaction);
	
	public boolean isObeyClassRule(String transactionCurrentState); 
}