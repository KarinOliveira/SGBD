package events;

import enums.TransactionStates;
import model.Event;
import model.Transaction;

public class TerminateEvent extends Event {
	
	public TerminateEvent(String eventTitle) {
		super(eventTitle);
	}

	@Override
	public void changeState(Transaction transaction) {
		if (isObeyClassRule(transaction.getCurrentState())) {
			transaction.setCurrentState(TransactionStates.PROCESS_EFFECTIVE.stateTitle);
		}
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {
		return transactionCurrentState.equals(TransactionStates.ACTIVE.stateTitle);
	}

}
