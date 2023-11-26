package com.animes_follow.animes_api.dto;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Animes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer animeId;
	
	@Column
	private String originalName;
	
	@Column
	private String englishName;
	
	@Column 
	private String imageUrl;
	
	@Column
	private Integer releaseYear;
	
	@Column
	private LocalDateTime registeredAt;
}
