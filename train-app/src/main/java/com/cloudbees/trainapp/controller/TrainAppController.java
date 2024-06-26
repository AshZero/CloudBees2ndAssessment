package com.cloudbees.trainapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudbees.trainapp.entity.Receipt;
import com.cloudbees.trainapp.entity.TicketPurchaseRequest;
import com.cloudbees.trainapp.entity.User;
import com.cloudbees.trainapp.service.ReceiptService;
import com.cloudbees.trainapp.service.TicketPurchaseService;
import com.cloudbees.trainapp.service.UserService;

@RestController
@RequestMapping("/train")
public class TrainAppController {

	@Autowired
	private TicketPurchaseService ticketPurchaseService;
	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private UserService userService;

	@PostMapping("/purchase")
	public Receipt submitTicketPurchase(@RequestBody TicketPurchaseRequest request) {
		return ticketPurchaseService.submitTicketPurchase(request);
	}

	@GetMapping("/receipt/{userId}")
	public String viewReceipt(@PathVariable Long userId) {
		Receipt receipt = receiptService.getReceiptByUserId(userId);
		if (receipt != null) {
			return receipt.generateReceipt();
		} else {
			return "Receipt not found for user ID: " + userId;
		}
	}

	@GetMapping("/users/seats")
	public Map<User, String> viewUsersAndSeats() {
		// Assuming you have a service to fetch users and their allocated seats
		return userService.getUsersAndSeats();
	}

	@DeleteMapping("/user/{userId}")
	public String removeUser(@PathVariable Long userId) {
		// Assuming you have a service to remove a user by user ID
		boolean removed = userService.removeUser(userId);
		if (removed) {
			return "User with ID: " + userId + " removed successfully.";
		} else {
			return "User with ID: " + userId + " not found.";
		}
	}

}
