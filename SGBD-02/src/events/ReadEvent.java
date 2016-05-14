package events;

import enums.TransactionStates;
import exceptions.StateNotAllowedException;
import model.Event;
import model.Transaction;

public class ReadEvent extends Event {
	
	public ReadEvent(String eventTitle) {
		super(eventTitle);
	}

	@Override
	public void changeState(Transaction transaction) throws StateNotAllowedException {		
		if (isObeyClassRule(transaction.getCurrentState())) {
			transaction.setCurrentState(TransactionStates.ACTIVE.stateTitle);
		} else {
			throw new StateNotAllowedException();
		}
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {		
		return transactionCurrentState.equals(TransactionStates.TRANSACTION_STARTED.stateTitle) || 
				transactionCurrentState.equals(TransactionStates.ACTIVE.stateTitle);
	}
}
