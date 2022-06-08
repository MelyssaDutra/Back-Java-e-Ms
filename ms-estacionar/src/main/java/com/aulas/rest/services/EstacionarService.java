package com.aulas.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulas.rest.entities.Estacionar;
import com.aulas.rest.feignclient.LocalFeignClient;
import com.aulas.rest.repository.EstacionarRepository;



@Service
public class EstacionarService {

	@Autowired
	EstacionarRepository repository;

	@Autowired
	LocalFeignClient localFeignClient;
	
	 public List<Estacionar> getAll(){
		  return repository.findAll(); 
	   }
	   
	 
	 public Estacionar save (Estacionar estacionar) {
		 localFeignClient.alterarStatusvaga(estacionar.getIdVaga(), true);
		 return repository.save(estacionar);
	 
	 
	 
	 
	   }
	   
	   public void cancelar(int idestacionar) {
		   Estacionar Estacionar = repository.findById(idestacionar).get();
		   localFeignClient.alterarStatusvaga(Estacionar.getId(), false);
		   repository.deleteById(idestacionar);
	   }
	}

