package com.aulas.rest.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalIdCache;

@Entity(name = "Vagas")
@Table(name = "vagas")
@NaturalIdCache
@Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Vagas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tipo;
	private boolean ocupada;
	
	@OneToMany(
		        mappedBy = "vagas",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
	private List<Intermediaria> listaUsuarios = new ArrayList<>();
	
	public Vagas() {
		
	}

	public Vagas(int id, String tipo, boolean ocupada) {
		this.id = id;
		this.tipo = tipo;
		this.ocupada = ocupada;
	}

	public int getIdvagas() {
		return id;
	}

	public void setIdvagas(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	public List<Intermediaria> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Intermediaria> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	@Override
	public boolean equals(Object o) {
	if (this == o)
	return true;
	if (o == null || getClass() != o.getClass())
	return false;
	Vagas vagas = (Vagas) o;
	return Objects.equals(tipo, vagas.tipo);
	}

	@Override
	public int hashCode() {
	return Objects.hash(tipo);
	}
}