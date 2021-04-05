package com.users.restapi.domain.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.restapi.domain.exception.HandleBusinessException;
import com.users.restapi.models.User;
import com.users.restapi.repository.UserRepository;

@Service   
public class CrudUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(User user) {
		User euserExists = userRepository.findByEmail(user.getEmail());
		
		if(euserExists != null && !euserExists.equals(user)) {
			throw new HandleBusinessException("Já existe usuário com este email");
		}
		user.setCreatedAt(LocalDateTime.now());
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User findById(long userId) {
		return userRepository.findById(userId);
	}
	
	public void delete(long userId) {
		userRepository.deleteById(userId);
	}
}
