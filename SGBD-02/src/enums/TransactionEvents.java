package enums;

public enum TransactionEvents {
	TRANSACTION_BEGIN("Begin"), 
	READ("Read"), 
	WRITE("Write"), 
	TRANSACTION_TERMINATE("Terminate"),
	TRANSACTION_ROLLBACK("Rollback"), 
	TRANSACTION_COMMIT("Commit"),
	TRANSACTION_FINISH("Finish");
	
	public String eventTitle;
	
	TransactionEvents(String eventTitle) {
		this.eventTitle = eventTitle;
	}
}