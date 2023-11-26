package com.animes_follow.animes_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animes_follow.animes_api.dto.*;

@Repository
public interface SeasonsRepository extends JpaRepository<Seasons,Long> {

	List<Seasons> findByAnimeId(Long animeId);

}
