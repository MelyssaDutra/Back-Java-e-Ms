package com.aulas.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.rest.entities.Vagas;
import com.aulas.rest.services.VagasService;

@RestController
@RequestMapping("/vagas")
public class VagasController {
	@Autowired
	VagasService service;

	
	@GetMapping
	public ResponseEntity<List<Vagas>> pegarVagas() {
		return ResponseEntity.ok(service.listTodas());
	}

	@GetMapping("/pesquisar/{idvaga}")
	public ResponseEntity<Vagas> pegarPorId(@PathVariable("idvaga") int idvaga) {
		return ResponseEntity.ok(service.pegarPorId(idvaga));
	}
	

	@GetMapping("{tipoVaga}")
	public ResponseEntity<Integer> sugerirVaga(@PathVariable("tipoVaga") String tipoVaga) {
		return ResponseEntity.ok(service.sugerirVaga(tipoVaga));
	}

	@PostMapping("/criar/{quantidade}")
	public ResponseEntity<String> salvar(@PathVariable ("quantidade") int quantidade) {
		return ResponseEntity.ok(service.salvar(quantidade));
	}
	
	@PutMapping("/{idvaga}/{novoStatus}")
	public ResponseEntity<String> alterarStatusVaga(@PathVariable("idvaga") int idvaga,@PathVariable("novoStatus") boolean novoStatus){
	service.reservarVaga(idvaga, novoStatus);
	return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/{idvaga}")
	public ResponseEntity<Vagas> alterar(@PathVariable("idvaga") int idvaga, @RequestBody Vagas vagas) {
		return ResponseEntity.ok(service.alterar(idvaga, vagas));
	}

	@DeleteMapping("/{idvagas}")
	public ResponseEntity<Vagas> deletar(@PathVariable("idvagas") int idvagas) {
		service.deletar(idvagas);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}