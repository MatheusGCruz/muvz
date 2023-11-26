package com.animes_follow.animes_api.controller;


import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.animes_follow.animes_api.dto.Episodes;
import com.animes_follow.animes_api.service.EpisodesService;

import jakarta.servlet.http.HttpServletResponse;


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
	
	@GetMapping("/latest/{nickName}/{anime}")
	public Episodes getlatestByUser(@PathVariable String nickName, @PathVariable String anime, HttpServletResponse response) throws Exception {
		try {
			return service.findLatestByNameAndUser("%"+anime+"%", nickName);
		} catch (Exception ex) {    
			response.sendError(HttpServletResponse.SC_NOT_FOUND, ex.getLocalizedMessage() );			
			return null;
		}
	}
	
	@GetMapping("/first/{nickName}/{anime}")
	public Episodes getFirstByUser(@PathVariable String nickName, @PathVariable String anime, HttpServletResponse response) throws Exception {
		try {
			return service.findFirstByName("%"+anime+"%", nickName);
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
