package com.user.restapi.service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.restapi.domain.models.User;
import com.user.restapi.respository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private EntityManager entity;

	@Autowired
    UserRepository userRepository;

    public Page<User> getUsers(@RequestParam int pageNumber, @RequestParam int pageSize,  @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return this.userRepository.findAll(pageable);
    }

    public User findById(long id){
    	return (this.userRepository.findById(id));
    }
    
    
    public User findByIdDetail(long id){
    	return userRepository.findByIUser(id);
    }
    
    
    
    public User save(User user){
    	return this.userRepository.save(user);
    }
    
    public void removeUser(long id) {
    	 this.userRepository.deleteById(id);
    }

}
