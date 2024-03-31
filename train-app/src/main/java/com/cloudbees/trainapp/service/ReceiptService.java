package com.cloudbees.trainapp.service;

import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.entity.Receipt;
import com.cloudbees.trainapp.entity.Ticket;
import com.cloudbees.trainapp.entity.User;

@Service
public class ReceiptService {

	public Receipt getReceiptByUserId(Long userId) {
		// Assuming you have a repository or database to fetch receipt by user ID
		// Here you would implement the logic to fetch the receipt based on the user ID
		// For demonstration purposes, let's assume a dummy implementation

		// Dummy receipt creation
		User user = new User("John", "Doe", "john.doe@example.com");
		Ticket ticket = new Ticket(userId, "From", "To", user, 100.0);
		return new Receipt(ticket);
	}
}