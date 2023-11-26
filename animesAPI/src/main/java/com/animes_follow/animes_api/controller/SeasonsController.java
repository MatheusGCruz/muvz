package com.animes_follow.animes_api.controller;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import com.animes_follow.animes_api.dto.Seasons;
import com.animes_follow.animes_api.dto.Users;
import com.animes_follow.animes_api.repository.UsersRepository;
import com.animes_follow.animes_api.service.SeasonsService;
import com.animes_follow.animes_api.service.UsersService;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/seasons")
public class SeasonsController {
	
	private final SeasonsService service;

	public SeasonsController(SeasonsService service) {
	  this.service = service;
	}
	  
	
	@GetMapping("/all")
	public List<Seasons> getAllSeasons(){
		return service.findAll();
	}
	
	@GetMapping("/anime/{id}")
	public List<Seasons> getAllAnimeSeasons(@PathVariable Long id){
		return service.findAllByAnimeId(id);
	}
	
	@PostMapping("/addNew")
	public Seasons addNewSeason(@RequestBody Seasons newSeason, HttpServletResponse response){
		return service.addNewSeason(newSeason);
	}
	
}
