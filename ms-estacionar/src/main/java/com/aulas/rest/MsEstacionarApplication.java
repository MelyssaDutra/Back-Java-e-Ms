package com.aulas.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsEstacionarApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEstacionarApplication.class, args);
	}

}
