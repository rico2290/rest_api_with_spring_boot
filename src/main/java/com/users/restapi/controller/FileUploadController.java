package com.users.restapi.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.users.restapi.domain.exception.HandleBusinessException;
import com.users.restapi.domain.service.CrudFileUploadService;
import com.users.restapi.models.FileUpload;
import com.users.restapi.models.User;
import com.users.restapi.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class FileUploadController {
	
	@Autowired
	private CrudFileUploadService crudFileUploadService;
	
	
	@ApiOperation(value = "Carregar arquivo")
	@PostMapping("/uploadFile")
	@ResponseStatus(HttpStatus.CREATED)
	public FileUpload create(@RequestBody FileUpload fileUpload) {
		
		return crudFileUploadService.create(fileUpload);
	
		
	}
}
