package com.learnit.operations.onlineshop.helpdesk.impl;

import java.util.PriorityQueue;
import java.util.Queue;
import com.learnit.operations.onlineshop.helpdesk.enteties.HelpDeskFacade;
import com.learnit.operations.onlineshop.helpdesk.enteties.SupportTicket;

public class DefaultHelpDeskFacade<T> implements HelpDeskFacade {

	private Queue<SupportTicket> listOfTickets;

	{
		listOfTickets = new PriorityQueue<SupportTicket>();
	}

	@Override
	public void addNewSupportTicket(SupportTicket supportTicket) {
		if (supportTicket != null) {
			listOfTickets.offer(supportTicket);
		}
	}

	@Override
	public SupportTicket getNextSupportTicket() {
		return listOfTickets.poll();
	}

	@Override
	public int getNumberOfTickets() {
		return listOfTickets.size();
	}

	public Queue<SupportTicket> getListOfTickets() {
		return listOfTickets;
	}
}
