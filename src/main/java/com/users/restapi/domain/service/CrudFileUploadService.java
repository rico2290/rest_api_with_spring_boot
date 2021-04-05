package com.users.restapi.domain.service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.users.restapi.domain.exception.HandleBusinessException;
import com.users.restapi.models.FileUpload;
import com.users.restapi.models.User;
import com.users.restapi.repository.FileRepository;
import com.users.restapi.repository.UserRepository;

@Service
public class CrudFileUploadService {
	
	@Autowired
	FileRepository fileRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public FileUpload create(FileUpload file) {
		
		User user = userRepository.findById(file.getUser().getId());
		System.out.println("Data hora atual ->"+LocalDateTime.now());
		file.setCreatedAt(LocalDateTime.now());
		if(user != null) {
			System.out.println("User: ->" + user.getName() +" Id-> "+user.getId());
			file.setUser(user);
			return fileRepository.save(file);
		
		}
		return fileRepository.save(file);	
		//return new HandleBusinessException("Usuário nao encontrado");
	}

}
