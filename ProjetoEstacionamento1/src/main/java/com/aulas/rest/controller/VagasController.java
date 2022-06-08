package com.aulas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.rest.entidades.Vagas;
import com.aulas.rest.servicos.VagasService;

@CrossOrigin
@RestController
@RequestMapping("/vagas")
public class VagasController {
	@Autowired
	VagasService service;

	@GetMapping
	public ResponseEntity<List<Vagas>> pegarVagas() {
		return ResponseEntity.ok(service.listTodas());
	}

	@GetMapping("/{idvagas}")
	public ResponseEntity<Vagas> pegarPorId(@PathVariable("idvagas") int idvagas) {
		return ResponseEntity.ok(service.pegarPorId(idvagas));
	}

	/*@PostMapping("{quantidade}")
	public ResponseEntity<Vagas> salvar(@PathVariable ("quantidade") int quantidade) {
		return ResponseEntity.ok(service.salvar(quantidade));
	}
*/
	@PutMapping("/{idvagas}/{novoStatus}")
	public ResponseEntity<String> alterarStatusvaga(@PathVariable("idvagas") int idvagas,@PathVariable("novoStatus") boolean novoStatus) {
		service.reservar(idvagas, novoStatus);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{idvagas}")
	public ResponseEntity<Vagas> deletar(@PathVariable("idvagas") int idvagas) {
		service.deletar(idvagas);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}