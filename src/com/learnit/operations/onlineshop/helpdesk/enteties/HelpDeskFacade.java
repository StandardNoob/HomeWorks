package com.learnit.operations.onlineshop.helpdesk.enteties;

public interface HelpDeskFacade {

	void addNewSupportTicket(SupportTicket supportTicket);

	SupportTicket getNextSupportTicket();

	int getNumberOfTickets();

}
