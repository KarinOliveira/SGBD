package enumeration;

public enum TransactionStates {
	
	TRANSACTION_STARTED("Transaction Started"), 
	ACTIVE("Active"), 
	PROCESS_CANCELLATION("Process Cancellation"), 
	PROCESS_EFFECTIVE("Process Effective"),
	EFFECTIVE("Effective"), 
	TRANSACTION_FINISHED("Transaction Finished");
	
	public String stateTitle;
	
	TransactionStates(String stateTitle) {
		this.stateTitle = stateTitle;
	}	
}
