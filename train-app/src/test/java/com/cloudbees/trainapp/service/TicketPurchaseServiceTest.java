package com.cloudbees.trainapp.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cloudbees.trainapp.dao.TrainAppRepository;
import com.cloudbees.trainapp.entity.Receipt;
import com.cloudbees.trainapp.entity.Ticket;
import com.cloudbees.trainapp.entity.TicketPurchaseRequest;
import com.cloudbees.trainapp.entity.User;

public class TicketPurchaseServiceTest {
	
	@Mock
    private TrainAppRepository trainAppRepository;

    private TicketPurchaseService ticketPurchaseService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ticketPurchaseService = new TicketPurchaseService();
        ticketPurchaseService.trainAppRepository = trainAppRepository;
    }

	@Test
	public void testSubmitTicketPurchase() {
		TicketPurchaseRequest request = new TicketPurchaseRequest("John", "Doe", "john.doe@example.com", "CityA", "CityB", "A1");
        User user = new User("John", "Doe", "john.doe@example.com");
        Ticket ticket = new Ticket(123456L, "CityA", "CityB", user, "A1");

       

        Receipt receipt = ticketPurchaseService.submitTicketPurchase(request);

        assertEquals(ticket.getUserId(), receipt.getTicket().getUserId());
        assertEquals(ticket.getFrom(), receipt.getTicket().getFrom());
        assertEquals(ticket.getTo(), receipt.getTicket().getTo());
        assertEquals(ticket.getUser(), receipt.getTicket().getUser());
        assertEquals(ticket.getSeatNo(), receipt.getTicket().getSeatNo());

        Mockito.verify(trainAppRepository, Mockito.times(1)).submitTicketPurchase((Mockito.any()));
	}

}
