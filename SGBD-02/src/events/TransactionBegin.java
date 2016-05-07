package events;

import enumeration.TransactionStates;
import interfaces.ChangeTransactionState;
import model.Transaction;

public class TransactionBegin implements ChangeTransactionState {

	@Override
	public void changeTransactionState(Transaction transaction) {
		transaction.setCurrentState(TransactionStates.TRANSACTION_STARTED.stateTitle);
	}

	@Override
	public boolean isObeyClassRule(String transactionCurrentState) {
		return true; //There's nothing to obey here.
	}
}
