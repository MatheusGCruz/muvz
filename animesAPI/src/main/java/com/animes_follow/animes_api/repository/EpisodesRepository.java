package com.animes_follow.animes_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.animes_follow.animes_api.dto.*;

@Repository
public interface EpisodesRepository extends JpaRepository<Episodes,Long> {

	List<Episodes> findAllByAnimeId(long l);

	Episodes findFirstByAnimeId(long animeId);

	@Query("SELECT ep FROM Episodes ep "
			+" WHERE animeId = :animeId "
			+" Order BY seasonId desc, episodeNumber desc")
	List<Episodes> latestEpisodeWatchedByAnimeName(@Param("animeId") Long animeId);
	
	@Query("SELECT ep FROM Episodes ep "
			+" WHERE animeId = :animeId "
			+" AND userId = :userId "
			+" Order BY seasonId asc, episodeNumber asc")
	List<Episodes> firstEpisodeWatchedByAnimeName(@Param("animeId") Long animeId, @Param("userId") Long userId);
	
	@Query("SELECT ep FROM Episodes ep "
			+" WHERE animeId = :animeId "
			+" AND userId = :userId "
			+" Order BY seasonId desc, episodeNumber desc")
	List<Episodes> latestEpisodeWatchedByAnimeNameAndUserId(@Param("animeId") Long animeId, @Param("userId") Long userId);

}
