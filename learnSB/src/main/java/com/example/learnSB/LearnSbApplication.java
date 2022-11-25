package com.example.learnSB;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearnSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSbApplication.class, args);
	}

	@Bean
	public ModelMapper getModalMapper() {
		return new ModelMapper();
	}
}
