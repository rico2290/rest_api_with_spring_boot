package com.users.restapi.repository;



import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.users.restapi.models.User;


public interface UserRepository extends JpaRepository<User, Long> {

	//@Query(value = "SELECT * FROM TB_USER", nativeQuery = true)
	User findById(long id);
	
	List<User> findByNameContaining(String name);
	User findByEmail(String email);
	User findOneByName(String name);
	
	@Query(value = "SELECT * FROM TB_USER", nativeQuery = true)
	default User getUserDetails(long id){
		return this.findById(id);
	}

}
