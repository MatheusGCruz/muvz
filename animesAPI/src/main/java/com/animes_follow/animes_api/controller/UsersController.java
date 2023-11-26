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

import com.animes_follow.animes_api.dto.Users;
import com.animes_follow.animes_api.repository.UsersRepository;
import com.animes_follow.animes_api.service.UsersService;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/users")
public class UsersController {
	
	private final UsersService service;

	public UsersController(UsersService service) {
	  this.service = service;
	}
	  
	@Autowired
	private UsersRepository usersRepository;
	
	
	
	@GetMapping("/all")
	public List<Users> getAllAnimes(){
		return service.findAll();
	}
	
	@PostMapping("/addNew")
	public Users addNewAnime(@RequestBody Users newUser, HttpServletResponse response){
		return service.addNewUser(newUser);
	}
	
}
