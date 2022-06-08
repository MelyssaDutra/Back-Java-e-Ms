package com.aulas.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entities.Vagas;


@Repository
public interface VagasRepository extends JpaRepository<Vagas, Integer> {
	

}
