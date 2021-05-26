package com.example.securingweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.entity"})
public class SecuringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuringWebApplication.class, args);
	}

}
