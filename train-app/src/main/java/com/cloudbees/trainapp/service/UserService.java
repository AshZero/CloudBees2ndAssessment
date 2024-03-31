package com.cloudbees.trainapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.entity.User;

@Service
public class UserService {

	// Dummy map to simulate users and their seats
	private Map<User, String> usersAndSeats = new HashMap<>();

	private Map<Long, User> users = new HashMap<>();



	public UserService() {
		// Initialize dummy data
		User user1 = new User("Alice", "Smith", "alice@example.com");
		User user2 = new User("Bob", "Johnson", "bob@example.com");
		usersAndSeats.put(user1, "Seat A1");
		usersAndSeats.put(user2, "Seat B2");
		
		users.put(1L, new User("Alice", "Smith", "alice@example.com"));
		users.put(2L, new User("Bob", "Johnson", "bob@example.com"));
	}

	public Map<User, String> getUsersAndSeats() {
		return usersAndSeats;
	}

	public boolean removeUser(Long userId) {
		// Assuming you have a repository or database to remove users
		// Here you would implement the logic to remove the user by userId
		// For demonstration purposes, let's assume a dummy implementation
		User removedUser = users.remove(userId);
		return removedUser != null;
	}
}
