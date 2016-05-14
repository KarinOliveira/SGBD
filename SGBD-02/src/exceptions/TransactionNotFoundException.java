package exceptions;

public class TransactionNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TransactionNotFoundException(String transactionId) {
		super("The Transaction " + transactionId + " cannot be found");
	}
}
