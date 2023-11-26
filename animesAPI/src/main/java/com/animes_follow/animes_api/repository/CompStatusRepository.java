package com.animes_follow.animes_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.animes_follow.animes_api.dto.*;

@Repository
public interface CompStatusRepository extends JpaRepository<CompStatus,Long> {

}
