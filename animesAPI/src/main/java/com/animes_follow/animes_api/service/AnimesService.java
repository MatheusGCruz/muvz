package com.animes_follow.animes_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animes_follow.animes_api.dto.Animes;
import com.animes_follow.animes_api.repository.AnimesRepository;

@Service
public class AnimesService {
	
	@Autowired
	private AnimesRepository animesRepository;
	
	public Animes addNewAnime(Animes newAnime) {
		return animesRepository.save(newAnime);
	}

}
