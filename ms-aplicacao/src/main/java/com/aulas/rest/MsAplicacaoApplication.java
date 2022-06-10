package com.aulas.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsAplicacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAplicacaoApplication.class, args);
	}

}
