package com.aulas.rest.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entidades.Vagas;

@Repository
public interface VagasRepositorio extends JpaRepository <Vagas, Integer> {

}