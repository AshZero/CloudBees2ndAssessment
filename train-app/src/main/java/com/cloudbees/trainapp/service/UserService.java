package com.cloudbees.trainapp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.dao.TrainAppRepository;
import com.cloudbees.trainapp.entity.User;

@Service
public class UserService {

	@Autowired
	private TrainAppRepository trainAppRepository;
	
	public Map<User, String> getUsersAndSeats() {
		return trainAppRepository.getUsersAndSeats();
	}

	public boolean removeUser(Long userId) {
		// Assuming you have a repository or database to remove users
		// Here you would implement the logic to remove the user by userId
		// For demonstration purposes, let's assume a dummy implementation
		return trainAppRepository.removeUser(userId);
	}
}
