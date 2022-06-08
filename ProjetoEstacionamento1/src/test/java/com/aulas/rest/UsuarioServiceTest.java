package com.aulas.rest;

import java.util.Optional;



import javax.persistence.EntityNotFoundException;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import com.aulas.rest.dto.UsuarioDTO;
import com.aulas.rest.entidades.Usuario;
import com.aulas.rest.repositorios.UsuarioRepositorio;
import com.aulas.rest.servicos.UsuarioService;



@ExtendWith(SpringExtension.class)
public class UsuarioServiceTest {
private int idExistente;
private int idInexistente;
// private UsuarioDTO usuariodto;
private Usuario usuario;
private Usuario usuario2;



@InjectMocks
private UsuarioService service;



@Mock
private UsuarioRepositorio repositorio;



// comportamentos mockito
@BeforeEach
void setup() {
idExistente = 1;
// usuariodto = new UsuarioDTO();
usuario = new Usuario();
idInexistente = 9;



Mockito.when(repositorio.findById(idExistente)).thenReturn(Optional.of(usuario));
Mockito.doThrow(EntityNotFoundException.class).when(repositorio).findById(idInexistente);
Mockito.doThrow(IllegalArgumentException.class).when(repositorio).save(usuario2);
Mockito.when(repositorio.save(usuario)).thenReturn(usuario);
}



@Test
void retornaNaoNuloQuandoPegarPorIdDaCerto() {
Assertions.assertNotNull(service.pegarPorId(idExistente));
Mockito.verify(repositorio).findById(idExistente);
}



@Test
void lancaExceptionEntityNotFoundExceptionQuandoIdNaoExiste() {
Assertions.assertThrows(EntityNotFoundException.class, () -> {
service.pegarPorId(idInexistente);
});
Mockito.verify(repositorio).findById(idInexistente);
}



@Test
void LancaExcecaoIllegalArgumentExceptionQuandoUsuarioNaoExiste() {
Assertions.assertThrows(IllegalArgumentException.class, () -> {
service.salvar(usuario2);
});
Mockito.verify(repositorio).save(usuario2);
}
@Test
void retornaUsuarioQuandoSalvoComSucesso() {
Assertions.assertNotNull(service.salvar(usuario));
Mockito.verify(repositorio).save(usuario);
}
}