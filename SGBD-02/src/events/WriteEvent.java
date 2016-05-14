package events;

import enums.TransactionStates;
import model.Event;
import model.Transaction;

public class WriteEvent extends Event {
	
	public WriteEvent(String eventTitle) {
		super(eventTitle);
	}

	@Override
	public void changeState(Transaction transaction) {		
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
