package com.example.projectIot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProjectIotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectIotApplication.class, args);
	}

}
