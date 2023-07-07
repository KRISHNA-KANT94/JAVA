package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankRestApiApplication.class, args);
	}
	
	@Bean
	public ModelMapper myMapper() {
		ModelMapper mapper= new ModelMapper();
	 mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	 return mapper;
	}

}
