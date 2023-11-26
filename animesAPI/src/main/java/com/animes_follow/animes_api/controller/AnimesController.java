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

import com.animes_follow.animes_api.dto.Animes;
import com.animes_follow.animes_api.repository.AnimesRepository;

import jakarta.servlet.http.HttpServletResponse;


//import at.favre.lib.crypto.bcrypt.BCrypt;
//import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/animes")
public class AnimesController {
	
	@Autowired
	private AnimesRepository animesRepository;
	
	@GetMapping("/all")
	public List<Animes> getAllAnimes(){
		return animesRepository.findAll();
	}
	
	@PostMapping("/addNew")
	public Animes addNewAnime(@RequestBody Animes newAnime, HttpServletResponse response){
		return animesRepository.save(newAnime);
	}
	
}
