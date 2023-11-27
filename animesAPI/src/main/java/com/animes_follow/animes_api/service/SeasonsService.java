package com.animes_follow.animes_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animes_follow.animes_api.dto.Animes;
import com.animes_follow.animes_api.dto.Seasons;
import com.animes_follow.animes_api.repository.AnimesRepository;
import com.animes_follow.animes_api.repository.SeasonsRepository;

@Service
public class SeasonsService {
	
	@Autowired
	private SeasonsRepository seasonRepository;
	
	@Autowired
	private AnimesRepository animesRepository;
	
	public Seasons addNewSeason(Seasons newSeason) throws Exception {
		Optional<Animes> targetAnime = animesRepository.findById((long) newSeason.getAnimeId());
		
		if(targetAnime.isEmpty()) {
			throw new Exception ("Anime not found");
		}
		
		newSeason.setRegisteredAt(LocalDateTime.now());
		return seasonRepository.save(newSeason);
	}

	public List<Seasons> findAll() {
		return seasonRepository.findAll();
	}
	
	public List<Seasons> findAllByAnimeId(Long animeId) {
		return seasonRepository.findByAnimeId(animeId);
	}

}
