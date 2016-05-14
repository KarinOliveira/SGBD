package events;

import enumeration.TransactionStates;
import interfaces.ChangeTransactionState;
import model.Transaction;

public class Read implements ChangeTransactionState {

	@Override
	public void changeTransactionState(Transaction transaction) {		
		if (isObeyClassRule(transaction.getCurrentState())) {
			transaction.setCurrentState(TransactionStates.ACTIVE.stateTitle);
		}
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {		
		return transactionCurrentState.equals(TransactionStates.TRANSACTION_STARTED.stateTitle) || 
				transactionCurrentState.equals(TransactionStates.ACTIVE.stateTitle);
	}
}
