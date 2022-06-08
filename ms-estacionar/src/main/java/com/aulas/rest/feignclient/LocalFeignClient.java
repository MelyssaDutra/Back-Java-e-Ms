package com.aulas.rest.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@Component
@FeignClient(name = "vagas", url = "localhost:8001", path = "/vagas")
public interface LocalFeignClient {


	@PutMapping("/{idvagas}/{novoStatus}")
	public ResponseEntity<String> alterarStatusvaga(@PathVariable("idvagas") int idvagas,@PathVariable("novoStatus") boolean novoStatus); 
		
	}

