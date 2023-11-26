package com.animes_follow.animes_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animes_follow.animes_api.dto.CompStatus;
import com.animes_follow.animes_api.repository.CompStatusRepository;

@Service
public class CompStatusService {
	
	@Autowired
	private CompStatusRepository compStatusRepository;
	
	public CompStatus addNewStatus(CompStatus newCompStatus) {
		newCompStatus.setRegisteredAt(LocalDateTime.now());
		return compStatusRepository.save(newCompStatus);
	}

	public List<CompStatus> findAll() {
		return compStatusRepository.findAll();
	}

}
