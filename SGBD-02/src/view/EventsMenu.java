package view;

import enums.TransactionEvents;

public class EventsMenu {
	
	public static void showEventsOptions() {
		int optionNumber = 1;
		
		System.out.println("\nChoose one of the following States: \n");
		
		for (TransactionEvents transactionsEvents : TransactionEvents.values()) {
			System.out.println(optionNumber + " - " + transactionsEvents.eventTitle);
			optionNumber++;
		}
	}	
}
