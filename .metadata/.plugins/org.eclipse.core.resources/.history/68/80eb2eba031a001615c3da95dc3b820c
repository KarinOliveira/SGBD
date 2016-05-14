package events;

import enums.TransactionStates;
import model.Event;
import model.Transaction;

public class RollbackEvent extends Event {

	public RollbackEvent(String eventTitle) {
		super(eventTitle);
	}

	@Override
	public void changeState(Transaction transaction) {
		if (isObeyClassRule(transaction.getCurrentState())) {
			transaction.setCurrentState(TransactionStates.PROCESS_CANCELLATION.stateTitle);
		}
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {
		return transactionCurrentState.equals(TransactionStates.ACTIVE.stateTitle) ||
				transactionCurrentState.equals(TransactionStates.PROCESS_EFFECTIVE.stateTitle);
	}

}
