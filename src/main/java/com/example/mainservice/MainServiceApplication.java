package com.example.mainservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController("/api/v1")
public class MainServiceApplication {
	// filter token
	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
	}
	@GetMapping("/sayHi")
	public String hello(){
		return "hello";
	}
}
