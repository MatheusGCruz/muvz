package com.animes_follow.animes_api.dto;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Episodes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer episodeId;
	
	@Column
	private Integer animeId;
	
	@Column
	private Integer seasonId;
	
	@Column
	private Integer userId;
	
	@Column
	private Integer episodeNumber;
	
	@Column
	private Integer episodeStatus;
	
	@Column
	private Integer episodeScore;
	
	@Column
	private LocalDateTime registeredAt;
}
