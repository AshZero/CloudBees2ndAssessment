package com.cloudbees.trainapp.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.entity.Receipt;
import com.cloudbees.trainapp.entity.Ticket;
import com.cloudbees.trainapp.entity.TicketPurchaseRequest;
import com.cloudbees.trainapp.entity.User;

@Service
public class TicketPurchaseService {

    public Receipt submitTicketPurchase(TicketPurchaseRequest request) {
    	Random random =  new Random();
    	
        User user = new User(request.getFirstName(), request.getLastName(), request.getEmail());
        Ticket ticket = new Ticket(random.nextLong(), request.getFrom(), request.getTo(), user, request.getPricePaid());
        return new Receipt(ticket);
    }
}
