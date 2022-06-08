package com.aulas.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entities.Usuario;



@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}