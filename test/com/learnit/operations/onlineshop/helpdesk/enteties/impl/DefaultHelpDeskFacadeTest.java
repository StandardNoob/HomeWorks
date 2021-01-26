package com.learnit.operations.onlineshop.helpdesk.enteties.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.learnit.operations.onlineshop.helpdesk.enteties.HelpDeskFacade;
import com.learnit.operations.onlineshop.helpdesk.enteties.RequestType;

@DisplayName("Tests DefaultHelpDeskFacade for online shop")
class DefaultHelpDeskFacadeTest {

	private HelpDeskFacade helpDesk;

	@BeforeEach
	void setUp() throws Exception {
		helpDesk = new DefaultHelpDeskFacade();
	}

	@Test
	void shouldAddNewSupportTicketWhenSupportTicketIsNotNull() {
		helpDesk.addNewSupportTicket(new DefaultSupportTicket(RequestType.ACCOUNT_IS_BLOCKED));
		assertEquals(helpDesk.getNumberOfTickets(), 1);
	}

	@Test
	void shouldDontAddNewSupportTicketWhenSupportTicketIsNull() {
		helpDesk.addNewSupportTicket(null);
		assertEquals(helpDesk.getNumberOfTickets(), 0);
	}

	@Test
	void shouldGetNextSupportTicketAndDelleteItFromQueue() {
		helpDesk.addNewSupportTicket(new DefaultSupportTicket(RequestType.ACCOUNT_IS_BLOCKED));
		helpDesk.addNewSupportTicket(new DefaultSupportTicket(RequestType.ACCOUNT_IS_BLOCKED));
		helpDesk.addNewSupportTicket(new DefaultSupportTicket(RequestType.ACCOUNT_IS_BLOCKED));
		helpDesk.getNextSupportTicket();
		assertEquals(helpDesk.getNumberOfTickets(), 2);
	}
}
