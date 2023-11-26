package com.animes_follow.animes_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animes_follow.animes_api.auxiliary.AuxiliaryFunctions;
import com.animes_follow.animes_api.dto.Animes;
import com.animes_follow.animes_api.dto.Episodes;
import com.animes_follow.animes_api.dto.Users;
import com.animes_follow.animes_api.repository.AnimesRepository;
import com.animes_follow.animes_api.repository.EpisodesRepository;
import com.animes_follow.animes_api.repository.UsersRepository;

@Service
public class EpisodesService {
	
	@Autowired
	private EpisodesRepository episodesRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AnimesRepository animesRepository;
	
	private AuxiliaryFunctions axiliaryFunctions;
	
	public Episodes addNew(Episodes newEpisode) throws Exception {
		try {
			if(axiliaryFunctions.isNull(newEpisode.getUserId())) {
				throw new Exception ("Invalid User");
			}
			
			if(axiliaryFunctions.isNull(newEpisode.getAnimeId())) {
				throw new Exception ("Invalid Anime");
			}
			
			
			Optional<Users> targetUser = usersRepository.findById((long) newEpisode.getUserId());
			Optional<Animes> targetAnime = animesRepository.findById((long) newEpisode.getAnimeId());
		
			if(targetUser.isEmpty()) {
				throw new Exception ("User not found");
			}	
		
			if(targetAnime.isEmpty()) {
				throw new Exception ("Anime not found");
			}	
		
			newEpisode.setRegisteredAt(LocalDateTime.now());
			return episodesRepository.save(newEpisode);
		}
		catch(Exception ex) {
			throw new Exception ("Error on search: "+ex.getMessage());
		}
	}



	public List<Episodes> findAll() {
		return episodesRepository.findAll();
	}



	public List<Episodes> findLatest(String anime) {
		return episodesRepository.latestEpisodesByAnimeName(anime);
		
	}
	
	public List<Episodes> findAllByName(String anime) throws Exception{
		try {
			Animes originalName =  animesRepository.findByOriginalNameLike(anime);			
			if(!axiliaryFunctions.isNull(originalName)) {
				return episodesRepository.findAllByAnimeId((long) originalName.getAnimeId());
			}
			
			Animes englishName =  animesRepository.findByEnglishNameLike(anime);
			if(!axiliaryFunctions.isNull(englishName)) {
				return episodesRepository.findAllByAnimeId((long) englishName.getAnimeId());
			}
			return List.of();
			
		}
		catch(Exception ex) {
			throw new Exception("Anime not Found");
			
		}	
		
	}
	
	public Episodes findLatestByName(String anime) throws Exception{
		try {
			Animes originalName =  animesRepository.findByOriginalNameLike(anime);			
			if(!axiliaryFunctions.isNull(originalName)) {
				return episodesRepository.findFirstByAnimeId((long) originalName.getAnimeId());
			}
			
			Animes englishName =  animesRepository.findByEnglishNameLike(anime);
			if(!axiliaryFunctions.isNull(englishName)) {
				return episodesRepository.findFirstByAnimeId((long) englishName.getAnimeId());
			}
			return null;
			
		}
		catch(Exception ex) {
			throw new Exception("Anime not Found");
			
		}	
		
	}

}
