package com.aulas.rest.entities;

import java.sql.Date;
import java.sql.Time;

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
	private  Date dataChegada;
	private Date dataSaida;
	private Time horaChegada;
	private Time horaSaida;
	private int idVaga;
	private int idUsuario;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataChegada() {
		return dataChegada;
	}
	public void setDataChegada(Date dataChegada) {
		this.dataChegada = dataChegada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Time getHoraChegada() {
		return horaChegada;
	}
	public void setHoraChegada(Time horaChegada) {
		this.horaChegada = horaChegada;
	}
	public Time getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Time horaSaida) {
		this.horaSaida = horaSaida;
	}
	public Estacionar() {
		
	
	}
	public int getIdVaga() {
		return idVaga;
	}
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}
	public Estacionar(int idVaga) {
		
		this.idVaga = idVaga;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Estacionar(int id, Date dataChegada, Date dataSaida, Time horaChegada, Time horaSaida, int idVaga,
			int idUsuario) {
		super();
		this.id = id;
		this.dataChegada = dataChegada;
		this.dataSaida = dataSaida;
		this.horaChegada = horaChegada;
		this.horaSaida = horaSaida;
		this.idVaga = idVaga;
		this.idUsuario = idUsuario;
	}

}
