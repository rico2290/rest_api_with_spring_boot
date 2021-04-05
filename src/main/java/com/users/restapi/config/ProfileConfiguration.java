package com.users.restapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

//@Configuration
@Profile("development")

@Development
public class ProfileConfiguration {
	
	@Bean
	public CommandLineRunner execute() {
		return args -> {
			System.out.println("RUNNING DEVELOPMENT CONFIGURATION");
		};
	}

}
