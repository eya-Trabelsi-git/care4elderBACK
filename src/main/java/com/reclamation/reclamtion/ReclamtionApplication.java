package com.reclamation.reclamtion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.reclamation.reclamtion.controller", "com.reclamation.reclamtion.repository", "com.reclamation.reclamtion.service","com.reclamation.reclamtion.serviceimplementation"})
@EntityScan(basePackages = "com.reclamation.reclamtion.model")
@EnableJpaRepositories(basePackages = "com.reclamation.reclamtion.repository")

public class ReclamtionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReclamtionApplication.class, args);
	}

}
