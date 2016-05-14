package events;

import enums.TransactionStates;
import model.Event;
import model.Transaction;

public class BeginEvent extends Event {
	
	public BeginEvent(String eventTitle) {
		super(eventTitle);
	}

	@Override
	public void changeState(Transaction transaction) {
		transaction.setCurrentState(TransactionStates.TRANSACTION_STARTED.stateTitle);
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {
		return true; //There's nothing to obey here.
	}
}
