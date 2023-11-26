package com.animes_follow.animes_api.dto;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Seasons {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seasonId;
	
	@Column
	private Integer animeId;
	
	@Column
	private Integer seasonNumber;
	
	@Column
	private String seasonName;
	
	@Column
	private LocalDateTime releaseDate;
	
	@Column
	private Integer numberOfEpisodes;
	
	@Column
	private Integer dayOfTheWeek;
	
	@Column
	private Integer seasonStatus;
	
	@Column
	private LocalDateTime registeredAt;
}
