package com.animes_follow.animes_api.dto;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@Column
	private String nickName;
	
	@Column
	private String userName;
	
	@Column
	private LocalDateTime registeredAt;
}
