package com.aulas.rest.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "estacionar", url = "localhost:8002", path= "/")
public interface FeignClientEstacionar {

	@PostMapping("/estacionar/{idVaga}/{idUsuario}")
	public ResponseEntity<String> save(@PathVariable("idVaga") int idVaga, @PathVariable("idUsuario") int idUsuario);
	
   
	}
	



