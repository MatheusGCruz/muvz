package com.animes_follow.animes_api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.animes_follow.animes_api.dto.Users;
import com.animes_follow.animes_api.service.UsersService;

import jakarta.servlet.http.HttpServletResponse;



@RestController
@RequestMapping("/users")
public class UsersController {
	
	private final UsersService service;

	public UsersController(UsersService service) {
	  this.service = service;
	}
	
	
	@GetMapping("/all")
	public List<Users> getAllUsers(){
		return service.findAll();
	}
	
	@PostMapping("/addNew")
	public Users addNewAnime(@RequestBody Users newUser, HttpServletResponse response) throws Exception{
		if(service.findUserId(newUser.getNickName()) > 0) {
			response.sendError(409);
		}
		return service.addNewUser(newUser);
	}
	
}
