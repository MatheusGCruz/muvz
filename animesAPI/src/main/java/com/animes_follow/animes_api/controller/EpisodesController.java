package com.animes_follow.animes_api.controller;

import java.io.Console;
import java.io.IOException;
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
import com.animes_follow.animes_api.dto.Episodes;
import com.animes_follow.animes_api.repository.AnimesRepository;
import com.animes_follow.animes_api.service.CompStatusService;
import com.animes_follow.animes_api.service.EpisodesService;

import jakarta.servlet.http.HttpServletResponse;


//import at.favre.lib.crypto.bcrypt.BCrypt;
//import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/episodes")
public class EpisodesController {
	
	private final EpisodesService service;

	public EpisodesController(EpisodesService service) {
	  this.service = service;
	}
	
	
	@GetMapping("/all")
	public List<Episodes> getAll(){
		return service.findAll();
	}
	
	@PostMapping("/addNew")
	public Episodes addNew(@RequestBody Episodes newEpisode, HttpServletResponse response) throws Exception{
		try {
			return service.addNew(newEpisode);
		} catch (Exception ex) {    
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getLocalizedMessage() );			
			return null;
		}
	}
	
	@GetMapping("/latest/{anime}")
	public Episodes getLatest(@PathVariable String anime, HttpServletResponse response) throws Exception {
		try {
			return service.findLatestByName("%"+anime+"%");
		} catch (Exception ex) {    
			response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getLocalizedMessage() );			
			return null;
		}
	}
	
	@GetMapping("/all/{anime}")
	public List<Episodes> getAllByName(@PathVariable String anime, HttpServletResponse response) throws Exception {
		try {
			return service.findAllByName("%"+anime+"%");
		} catch (Exception ex) {    
			response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getLocalizedMessage() );			
			return null;
		}
	}
	
}
