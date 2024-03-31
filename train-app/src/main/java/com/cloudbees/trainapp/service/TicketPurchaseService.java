package com.cloudbees.trainapp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.dao.TrainAppRepository;
import com.cloudbees.trainapp.entity.Receipt;
import com.cloudbees.trainapp.entity.Ticket;
import com.cloudbees.trainapp.entity.TicketPurchaseRequest;
import com.cloudbees.trainapp.entity.User;

@Service
public class TicketPurchaseService {

	@Autowired
	TrainAppRepository trainAppRepository;

	public Receipt submitTicketPurchase(TicketPurchaseRequest request) {
		Random random = new Random();

		User user = new User(request.getFirstName(), request.getLastName(), request.getEmail());
		Ticket ticket = new Ticket(random.nextLong(), request.getFrom(), request.getTo(), user, request.getSeatNo());
		trainAppRepository.submitTicketPurchase(ticket);
		return new Receipt(ticket);
	}
}
