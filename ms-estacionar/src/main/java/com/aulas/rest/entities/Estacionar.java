package com.aulas.rest.entities;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_estacionar")
public class Estacionar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//private  Date dataChegada;
	//private Date dataSaida;
	//private Time horaChegada;
	//private Time horaSaida;
	private Instant dataHoraChegada;
	private Instant dataHoraSaida;
	
	private int idVaga;
	private int idUsuario;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Instant getDataHoraChegada() {
		return dataHoraChegada;
	}
	
	public void setDataHoraChegada() {
		this.dataHoraChegada = Instant.now();
	}
	
	public Instant getDataHoraSaida() {
		return dataHoraSaida;
	}
	
	public void setDataHoraSaida() {
		this.dataHoraSaida = Instant.now();
	}
	
	public int getIdVaga() {
		return idVaga;
	}
	
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Estacionar(int id, Instant dataHoraChegada, Instant dataHoraSaida, int idVaga, int idUsuario) {
		super();
		this.id = id;
		this.dataHoraChegada = dataHoraChegada;
		this.dataHoraSaida = dataHoraSaida;
		this.idVaga = idVaga;
		this.idUsuario = idUsuario;
	}
	
	public Estacionar() {
		
	}

}