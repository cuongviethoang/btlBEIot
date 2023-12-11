package com.example.projectIot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ProjectIotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectIotApplication.class, args);
	}

}

// mosquitto_pub -t <topic> -m "{\"temp\": 30.5, \"humidity\": 50.8, \"brightness\": 400, \"dust\": 80}" -u admin -P 12345678 -h 192.193.3.100 -p 1883
