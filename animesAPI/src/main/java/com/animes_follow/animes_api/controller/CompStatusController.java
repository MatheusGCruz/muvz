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

import com.animes_follow.animes_api.dto.CompStatus;
import com.animes_follow.animes_api.service.CompStatusService;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/complementaryStatus")
public class CompStatusController {
	
	private final CompStatusService service;

	public CompStatusController(CompStatusService service) {
	  this.service = service;
	}
	  
	
	@GetMapping("/all")
	public List<CompStatus> getAll(){
		return service.findAll();
	}
	
	@PostMapping("/addNew")
	public CompStatus addNewAnime(@RequestBody CompStatus newStatus, HttpServletResponse response){
		return service.addNewStatus(newStatus);
	}
	
}
