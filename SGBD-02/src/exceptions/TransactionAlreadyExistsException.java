package exceptions;

public class TransactionAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public TransactionAlreadyExistsException(String transactionId) {
		super("The Transaction " + transactionId + " already exists!");
	}
}