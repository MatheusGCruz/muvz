package com.animes_follow.animes_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animes_follow.animes_api.dto.*;

@Repository
public interface AnimesRepository extends JpaRepository<Animes,Long> {

	Animes findByOriginalNameLike(String anime);

	Animes findByEnglishNameLike(String anime);

	Animes findByEnglishName(String animeName);

	Animes findByOriginalName(String animeName);

}
