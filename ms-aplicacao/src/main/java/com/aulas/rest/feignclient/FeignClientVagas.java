package com.aulas.rest.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name = "vagas", url = "localhost:8001", path = "/vagas")
public interface FeignClientVagas {


	@GetMapping("/{tipoVaga}")
	public ResponseEntity<Integer> sugerirVaga(@PathVariable("tipoVaga") String tipoVaga);
	
	
	
}
