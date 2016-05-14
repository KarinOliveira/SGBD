package exceptions;

public class StateNotAllowedException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public StateNotAllowedException() {
		super("This State isn't allowed for this Transaction!");
	}
}
