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

import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entities.Usuario;
import com.aulas.rest.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService service;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> pegarUsuarios() {
		return ResponseEntity.ok(service.listTodos());
	}

	@GetMapping("/{idusuario}")
	public ResponseEntity<UsuarioDTO> pegarPorId(@PathVariable("idusuario") int idusuario) {
		return ResponseEntity.ok(service.pegarPorId(idusuario));
	}

	
	@GetMapping("/{idusuario}/{tipoVaga}")
	public ResponseEntity<Integer> SugerirVaga(@PathVariable("idusuario") int idusuario, @PathVariable("tipoVaga") String tipoVaga) {
		return ResponseEntity.ok(service.estacionar(idusuario, tipoVaga));
	}
	
	/*@PostMapping("/login")
	public ResponseEntity<UsuarioDTO> salvarLogin(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(service.salvar(usuario));
	}*/
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(service.salvar(usuario));
	}

	@PutMapping("/{idusuario}")
	public ResponseEntity<UsuarioDTO> alterar(@PathVariable("idusuario") int idusuario, @RequestBody Usuario usuario) {
		return ResponseEntity.ok(service.alterar(idusuario, usuario));
	}

	@DeleteMapping("/{idusuario}")
	public ResponseEntity<UsuarioDTO> deletar(@PathVariable("idusuario") int idusuario) {
		try {
			service.deletar(idusuario);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}
}