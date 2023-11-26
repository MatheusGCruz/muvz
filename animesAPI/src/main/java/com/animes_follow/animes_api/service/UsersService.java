package com.animes_follow.animes_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animes_follow.animes_api.auxiliary.AuxiliaryFunctions;
import com.animes_follow.animes_api.dto.Users;
import com.animes_follow.animes_api.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository userRepository;
	
	private AuxiliaryFunctions auxiliaryFunctions;
	
	public UsersService(AuxiliaryFunctions auxiliaryFunctions) {
		  this.auxiliaryFunctions = auxiliaryFunctions;
	}
	
	public Users addNewUser(Users newUser) {
		newUser.setRegisteredAt(LocalDateTime.now());
		return userRepository.save(newUser);
	}

	public List<Users> findAll() {
		return userRepository.findAll();
	}
	
	public Long findUserId(String nickName) {
		Users targetUser = userRepository.findByNickName(nickName);
		
		if(!auxiliaryFunctions.isNull(targetUser)) {
			return (long) targetUser.getUserId();
		}
		
		return (long) 0;
		
	}

}
