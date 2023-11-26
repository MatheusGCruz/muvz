package com.animes_follow.animes_api.dto;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class CompStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer compStatusId;

	@Column
	private String statusName;
	
	@Column
	private String statusType;
	
	@Column
	private LocalDateTime registeredAt;
}
