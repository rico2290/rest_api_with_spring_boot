/**
 * 
 */
package com.users.restapi.config;

import java.io.Serializable;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author rico22
 **
 */
@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final long JWT_VALIDITY = 5 * 60 * 60;
	
	//@Value("${jwt.secret}");
	//private String secret; 
	
	//return user and the token jwt
	public String getUsernameFromToken(String token) {
		return token;
	}
	
	

}
