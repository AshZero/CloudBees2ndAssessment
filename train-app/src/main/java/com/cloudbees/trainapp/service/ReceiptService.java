package com.cloudbees.trainapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudbees.trainapp.dao.TrainAppRepository;
import com.cloudbees.trainapp.entity.Receipt;

@Service
public class ReceiptService {

	@Autowired
	TrainAppRepository trainAppRepository;

	public Receipt getReceiptByUserId(Long userId) {
		return trainAppRepository.getReceiptByUserId(userId);
	}
}