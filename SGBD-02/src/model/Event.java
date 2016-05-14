package model;

import exceptions.StateNotAllowedException;

public abstract class Event {
	
	protected String eventTitle;
	
	public Event(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
	public String getStateTitle() {
		return eventTitle;
	}
	
	public abstract void changeState(Transaction transaction) throws StateNotAllowedException;
	
	public abstract boolean isObeyClassRule(String transactionCurrentState);
}
