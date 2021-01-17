package com.learnit.operations.onlineshop.helpdesk.enteties;

public interface SupportTicket {

	Priority getPriority();

	int getSequentialNumber();

	RequestType getRequestType();

}
