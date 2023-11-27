package com.animes_follow.animes_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.animes_follow.animes_api.dto.Seasons;
import com.animes_follow.animes_api.service.SeasonsService;
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
	public Seasons addNewSeason(@RequestBody Seasons newSeason, HttpServletResponse response) throws Exception{
		try {
			return service.addNewSeason(newSeason);
		} catch (Exception ex) {    
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getLocalizedMessage() );			
			return null;
		}		
	}
	
}
