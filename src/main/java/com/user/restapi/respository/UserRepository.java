package com.user.restapi.respository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.restapi.domain.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(long id);
	User findByEmail(String email);
	
	 @Query("select u from User u where u.id = :id")
	 User findByIdDetails(@PathVariable("id") long id );
	 
	 default User findByIUser(long id) {
		  return findByIdDetails(id);
		}


}
