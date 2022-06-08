package com.aulas.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.rest.entities.Estacionar;

@Repository
public interface EstacionarRepository extends JpaRepository<Estacionar, Integer>{

}
