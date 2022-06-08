package com.aulas.rest.entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "Intermediaria")
@Table(name = "Intermediaria")
public class Intermediaria {

	@EmbeddedId
	private IntermediariaId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("usuariosId")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("vagasId")
	private Vagas vagas;

	private Date data;
	private Time hora;

	public Intermediaria() {

	}

	public Intermediaria(Usuario usuario, Vagas vagas) {
		this.usuario = usuario;
		this.vagas = vagas;
		this.id = new IntermediariaId(usuario.getId(), vagas.getIdvagas());
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public IntermediariaId getId() {
		return id;
	}

	public void setId(IntermediariaId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vagas getVagas() {
		return vagas;
	}

	public void setVagas(Vagas vagas) {
		this.vagas = vagas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Intermediaria that = (Intermediaria) o;
		return Objects.equals(usuario, that.usuario) && Objects.equals(vagas, that.vagas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuario, vagas);
	}
}