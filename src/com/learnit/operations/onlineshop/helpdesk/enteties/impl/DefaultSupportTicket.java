package com.learnit.operations.onlineshop.helpdesk.enteties.impl;

import com.learnit.operations.onlineshop.helpdesk.enteties.Priority;
import com.learnit.operations.onlineshop.helpdesk.enteties.RequestType;
import com.learnit.operations.onlineshop.helpdesk.enteties.SupportTicket;

public class DefaultSupportTicket implements SupportTicket, Comparable<SupportTicket> {

	private RequestType requestType;
	private int sequentialNumber;
	private static int numOfAllTickets;

	{
		sequentialNumber = ++numOfAllTickets;
	}

	public DefaultSupportTicket(RequestType requestType) {
		this.requestType = requestType;
	}

	@Override
	public Priority getPriority() {
		return this.requestType.getPriority();
	}

	@Override
	public int getSequentialNumber() {
		return sequentialNumber;
	}

	@Override
	public RequestType getRequestType() {
		return this.requestType;
	}

	
	public int compareTo(SupportTicket o) {
		int compareResult = 0;
		if (o == null) {
			return compareResult;
		}
		compareResult = o.getPriority().compareTo(this.getPriority());
		if (compareResult == 0) {
			compareResult = o.getSequentialNumber() - this.getSequentialNumber();
		}
		return compareResult;
	}

	@Override
	public String toString() {
		return "DefaultSupportTicket #" + sequentialNumber + ", Request Type: " + getRequestType() + ";";
	}

}
