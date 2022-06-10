package com.aulas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.rest.entities.Estacionar;
import com.aulas.rest.services.EstacionarService;

@RestController
@RequestMapping("/")
public class EstacionarController {
	@Autowired
	EstacionarService service;


	@GetMapping("/estacionar")
	public ResponseEntity<List<Estacionar>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
	}
	
	@PostMapping("/estacionar/{idVaga}/{idUsuario}")
	public ResponseEntity<String> save(@PathVariable("idVaga") int idVaga, @PathVariable("idUsuario") int idUsuario){
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(idVaga, idUsuario));
	}
	
	@DeleteMapping("/estacionar/{idestacionar}")
	public ResponseEntity<Void> cancelar(@PathVariable("idlocacao") int idestacionar){
		service.cancelar(idestacionar);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}

