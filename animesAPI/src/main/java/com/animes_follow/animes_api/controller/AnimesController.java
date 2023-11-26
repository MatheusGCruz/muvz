package com.animes_follow.animes_api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.animes_follow.animes_api.dto.Animes;
import com.animes_follow.animes_api.service.AnimesService;

import jakarta.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/animes")
public class AnimesController {
	
	@Autowired
	private AnimesService animesService;
	
	@GetMapping("/all")
	public List<Animes> getAllAnimes(){
		return animesService.findAll();
	}
	
	@PostMapping("/addNew")
	public Animes addNewAnime(@RequestBody Animes newAnime, HttpServletResponse response) throws IOException{
		if(animesService.getAnimeIdByExactName(newAnime.getOriginalName()) > 0) {
			response.sendError(409);
		}
		if(animesService.getAnimeIdByExactName(newAnime.getEnglishName()) > 0) {
			response.sendError(409);
		}
		return animesService.addNewAnime(newAnime);
	}
	
}
