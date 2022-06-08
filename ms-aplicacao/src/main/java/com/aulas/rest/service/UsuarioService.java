package com.aulas.rest.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entities.Usuario;
import com.aulas.rest.repository.UsuarioRepository;
//import com.aulas.rest.servicos.excecoes.RecursoNaoEncontrado;



@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repo;
	
	public List<UsuarioDTO> listTodos(){
		List<UsuarioDTO> lista = new ArrayList<>();
		
		List<Usuario> usuarios = repo.findAll();
		for(Usuario user : usuarios) {
			lista.add(new UsuarioDTO(user));
		}
		return lista;
	}
	
	public UsuarioDTO pegarPorId (int idusuario) {
		//Optional<Usuario> obj = repo.findById(idusuario);
		//Usuario user = obj.orElseThrow(() -> new RecursoNaoEncontrado("Usuário não encontrado."));
		Usuario user = repo.findById(idusuario).get();
		return new UsuarioDTO (user);
		
	}

	public UsuarioDTO salvar(Usuario usuario) {
		Usuario user = repo.save(usuario);
		return new UsuarioDTO(user);
	}
	
	public UsuarioDTO alterar(int idusuario, Usuario usuario) {
		//Optional<Usuario> obj = repo.findById(idusuario);//
		Usuario user = repo.findById(idusuario).get();
		//Usuario user = obj.orElseThrow(() -> new RecursoNaoEncontrado ("Usuário não encontrado."));
		
		user.setNome(usuario.getNome());
		user.setEmail(usuario.getEmail());
		user.setDatanascimento(usuario.getDatanascimento());
		user.setGestante(usuario.getGestante());
		user.setPcd(usuario.getPcd());
		user.setPerfil(usuario.getPerfil());
		user.setSenha(usuario.getSenha());
		user = repo.save(user);
		return new UsuarioDTO(user);

	}
	public void deletar(int idusuario) {
		repo.deleteById(idusuario);
	}
	
	
}