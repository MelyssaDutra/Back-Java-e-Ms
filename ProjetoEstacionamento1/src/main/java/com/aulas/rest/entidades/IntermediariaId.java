package com.aulas.rest.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IntermediariaId implements Serializable {
	@Column(name = "usuario_id")
	private int usuarioId;

	@Column(name = "vagas_id")
	private int vagasId;

	public IntermediariaId() {

	}

	public IntermediariaId(int usuarioId, int vagasId) {
		this.usuarioId = usuarioId;
		this.vagasId = vagasId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public int getVagasId() {
		return vagasId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		IntermediariaId that = (IntermediariaId) o;
		return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(vagasId, that.vagasId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioId, vagasId);
	}

}