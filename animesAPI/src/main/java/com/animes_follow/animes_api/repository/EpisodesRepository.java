package com.animes_follow.animes_api.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.animes_follow.animes_api.dto.*;

@Repository
public interface EpisodesRepository extends JpaRepository<Episodes,Long> {

	@Query("SELECT ep FROM Episodes ep ")
			//+ " INNER JOIN Animes an on an.animeId = ep.animeId ")
			//+ " WHERE an.originalName like '%tate%' "
			//+ " OR an.englishName like '%tate%")
	List<Episodes> latestEpisodesByAnimeName(@Param("animeName") String animeName);

	List<Episodes> findAllByAnimeId(long l);

	Episodes findFirstByAnimeId(long animeId);


}
