package com.aulas.rest.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vagas")
public class Vagas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipo;
	private boolean ocupada;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean isOcupada() {
		return ocupada;
	}
	
	 
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	public Vagas() {
		super();
		
	}
	public Vagas(int id, String tipo, boolean ocupada) {
		
		this.id = id;
		this.tipo = tipo;
		this.ocupada = ocupada;
	}
	
	
}
