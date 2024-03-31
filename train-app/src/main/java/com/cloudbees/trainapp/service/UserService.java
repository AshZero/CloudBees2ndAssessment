package com.cloudbees.trainapp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.dao.TrainAppRepository;
import com.cloudbees.trainapp.entity.User;

@Service
public class UserService {

	@Autowired
	TrainAppRepository trainAppRepository;

	public Map<User, String> getUsersAndSeats() {
		return trainAppRepository.getUsersAndSeats();
	}

	public boolean removeUser(Long userId) {
		return trainAppRepository.removeUser(userId);
	}
}
