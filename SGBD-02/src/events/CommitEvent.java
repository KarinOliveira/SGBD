package events;

import enums.TransactionStates;
import exceptions.StateNotAllowedException;
import model.Event;
import model.Transaction;

public class CommitEvent extends Event {

	public CommitEvent(String eventTitle) {
		super(eventTitle);
	}

	@Override
	public void changeState(Transaction transaction) throws StateNotAllowedException {
		if (isObeyClassRule(transaction.getCurrentState())) {
			transaction.setCurrentState(TransactionStates.EFFECTIVE.stateTitle);
		} else {
			throw new StateNotAllowedException();
		}
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {
		return transactionCurrentState.equals(TransactionStates.PROCESS_EFFECTIVE.stateTitle);
	}

}
