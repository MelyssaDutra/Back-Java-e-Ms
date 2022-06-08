package com.aulas.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.aulas.rest.entidades.Usuario;
import com.aulas.rest.repositorios.UsuarioRepositorio;
import com.aulas.rest.servicos.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioServiceTestIt {
		private int idExistente;
		private int idInexistente;
		private Usuario usuario;
		private Usuario usuario2;
		
		@Autowired
		private MockMvc mockMvc;
		
		@Autowired
		private UsuarioService service;
		
		@Autowired
		private UsuarioRepositorio repositorio;
		
		
		@Autowired
		ObjectMapper objectMapper;
		
		@BeforeEach
		void setup() {
			idExistente = 1;
			usuario = new Usuario();
			idInexistente = 100;
		}
		
		
		

		@Test
		void lancaExceptionEntityNotFoundExceptionQuandoIdNaoExisteIt() throws Exception {
			ResultActions result = mockMvc
					.perform(get("/usuario/{idusuario}", idInexistente).accept(MediaType.APPLICATION_JSON));
					result.andExpect(status().isNotFound());
		}
		
		
		@Test
	    void deveRetornarOkQuandoPesquisaIdExistenteIt() throws Exception {
		    ResultActions result =	mockMvc.perform(get("/usuario/{idusuario}", idExistente)
			       .accept(MediaType.APPLICATION_JSON));
		    result.andExpect(status().isOk());
		}

		
		@Test
		void retornaUsuarioQuandoSalvoComSucesso() throws Exception {
			String jsonBody = objectMapper.writeValueAsString(usuario);
			ResultActions result = mockMvc
					.perform(post("/usuario")
							.accept(MediaType.APPLICATION_JSON)
							.content(jsonBody)
							   .contentType(MediaType.APPLICATION_JSON));
							   
						result.andExpect(status().isOk());
		}
		
		@Test
		void retornaStatus200QuandoUsuarioSalvoComSucesso() throws Exception {
			String jsonBody = objectMapper.writeValueAsString(usuario);
			ResultActions result = mockMvc
					.perform(post("/usuario")
							.accept(MediaType.APPLICATION_JSON)
							.content(jsonBody)
							   .contentType(MediaType.APPLICATION_JSON));
							   
						result.andExpect(status().isOk());
		}
		
		
		@Test
		void retornaStatus400QuandoUsuarioNaoSalvoComSucesso() throws Exception {
			String jsonBody = objectMapper.writeValueAsString(usuario2);
			ResultActions result = mockMvc
					.perform(post("/usuario")
							.accept(MediaType.APPLICATION_JSON)
							.content(jsonBody)
							   .contentType(MediaType.APPLICATION_JSON));
							   
						result.andExpect(status().isBadRequest());
		}
		
		
		@Test
		void retornaStatus200QuandoAlterarUsuarioComSucesso() throws Exception  {
			String jsonBody = objectMapper.writeValueAsString(usuario);
			ResultActions result = mockMvc
					.perform(put("/usuario/{idusuario}", idExistente)
							.accept(MediaType.APPLICATION_JSON)
							.content(jsonBody)
							   .contentType(MediaType.APPLICATION_JSON));
							   
			           result.andExpect(status().isOk());
			  
		}
		
		@Test
		void retornaStatus404QuandoAlterarUsuarioIdInexistente() throws Exception  {
			String jsonBody = objectMapper.writeValueAsString(usuario);
			ResultActions result = mockMvc
					.perform(put("/usuario/{idusuario}", idInexistente)
							.accept(MediaType.APPLICATION_JSON)
							.content(jsonBody)
							   .contentType(MediaType.APPLICATION_JSON));
							   
			           result.andExpect(status().isNotFound());
			  
		}
		
		@Test
		void retornaStatus400QuandoAlterarUsuarioComSucesso() throws Exception  {
			String jsonBody = objectMapper.writeValueAsString(usuario2);
			ResultActions result = mockMvc
					.perform(put("/usuario/{idusuario}", idExistente)
							.accept(MediaType.APPLICATION_JSON)
							.content(jsonBody)
							   .contentType(MediaType.APPLICATION_JSON));
							   
			           result.andExpect(status().isBadRequest());
			  
		}
		
			  
		
		@Test
		void retornaStatus204QuandoDeletaUsuarioComSucesso() throws Exception  {
			ResultActions result = mockMvc
					.perform(delete("/usuario/{idusuario}", idExistente)
							.accept(MediaType.APPLICATION_JSON));
							 
							   
			           result.andExpect(status().isNoContent());
			  
}
		
		@Test
		void retornaStatus404QuandoDeletaUsuarioComIdInexistente() throws Exception  {
			ResultActions result = mockMvc
					.perform(delete("/usuario/{idusuario}", idInexistente)
							.accept(MediaType.APPLICATION_JSON));
							 
							   
			           result.andExpect(status().isNotFound());
		}		  
}


