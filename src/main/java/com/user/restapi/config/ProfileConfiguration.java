package com.user.restapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("development")

@Development
public class ProfileConfiguration {
	
	@Value("${spring.profiles.active}")
	private String enviroment;
	
	@Bean
	public CommandLineRunner execute() {
		return args -> {
			System.out.println("RUNNING " +enviroment+" CONFIGURATION");
		};
	}

}