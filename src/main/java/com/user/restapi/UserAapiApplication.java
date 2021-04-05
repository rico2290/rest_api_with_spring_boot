package com.user.restapi;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.user.restapi.domain.models.User;
import com.user.restapi.respository.UserRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class UserAapiApplication {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${server.servlet.context-path}")
	private String context_path;


	public static void main(String[] args) {
		SpringApplication.run(UserAapiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserRepository userRepository){
		return new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				Random random = new Random();
				IntStream.rangeClosed(1, random.nextInt(100)).forEach(i ->{
					User user = new User();
					user.setNome("user"+ i);
					user.setEmail("user"+ i + "@example.com");
					user.setEndereco("endereço"+ random.nextInt(10) );
					user.setCidade("cidade "+ random.nextInt(100) );
					user.setCreatedAt(LocalDateTime.now());
					userRepository.save(user);
				});
				
				System.out.println(applicationName);
				System.out.println("ACESSE O LINK A SEGUIR PRA TESTAR: "+ "http://localhost:"+port+context_path+"/swagger-ui.html#/");
				
				
			}
			
		};



	}
}
