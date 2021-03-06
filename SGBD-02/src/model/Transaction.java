package model;

import java.util.ArrayList;

public class Transaction {
	private String id;
	private String currentState;
	
	public Transaction(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	
	@Override
	public String toString() {
		return "Id: " + this.id + "\nCurrent State: " + this.currentState;
	}
}
