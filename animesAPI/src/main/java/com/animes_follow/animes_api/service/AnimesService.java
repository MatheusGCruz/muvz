package com.animes_follow.animes_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animes_follow.animes_api.auxiliary.AuxiliaryFunctions;
import com.animes_follow.animes_api.dto.Animes;
import com.animes_follow.animes_api.repository.AnimesRepository;

@Service
public class AnimesService {
	
	@Autowired
	private AnimesRepository animesRepository;
	
	private AuxiliaryFunctions axiliaryFunctions;
	
	public AnimesService(AuxiliaryFunctions axiliaryFunctions) {
		  this.axiliaryFunctions = axiliaryFunctions;
	}
	
	public Animes addNewAnime(Animes newAnime) {
		return animesRepository.save(newAnime);
	}
	
	public Long getAnimeIdByLikeName(String animeName) {
		Animes originalName =  animesRepository.findByOriginalNameLike(animeName);
		if(!axiliaryFunctions.isNull(originalName)) {
			return (long)originalName.getAnimeId();
		}
		
		Animes englishName =  animesRepository.findByEnglishNameLike(animeName);
		if(!axiliaryFunctions.isNull(englishName)) {
			return (long)englishName.getAnimeId();
		}
		
		return (long) 0;
	}
	
	public Long getAnimeIdByExactName(String animeName) {
		Animes originalName =  animesRepository.findByOriginalName(animeName);
		if(!axiliaryFunctions.isNull(originalName)) {
			return (long)originalName.getAnimeId();
		}
		
		Animes englishName =  animesRepository.findByEnglishName(animeName);
		if(!axiliaryFunctions.isNull(englishName)) {
			return (long)englishName.getAnimeId();
		}
		
		return (long) 0;
	}

	public List<Animes> findAll() {
		return animesRepository.findAll();
	}

}
