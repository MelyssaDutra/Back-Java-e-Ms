package com.aulas.rest.entidades;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity(name = "Usuario")
@Table(name = "usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String nome;
	private String senha;
	private Date datanascimento;
	private char gestante;
	private char pcd;
	private String perfil;
	/*@Column(columnDefinition = "TIMESTAMP WHITHOUT TIME ZONE")
	private Instant createdAt;
	@Column(columnDefinition = "TIMESTAMP WHITHOUT TIME ZONE")
	private Instant updateAt;*/
	

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Intermediaria> lista = new ArrayList<>();

	public Usuario() {

	}

	public Usuario(int id, String email, String nome, String senha, Date datanascimento, char gestante, char pcd,
			String perfil) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.datanascimento = datanascimento;
		this.gestante = gestante;
		this.pcd = pcd;
		this.perfil = perfil;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public char getGestante() {
		return gestante;
	}

	public void setGestante(char gestante) {
		this.gestante = gestante;
	}

	public char getPcd() {
		return pcd;
	}

	public void setPcd(char pcd) {
		this.pcd = pcd;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void addVagas(Vagas vagas) {
		Intermediaria intermediaria = new Intermediaria(this, vagas);
		lista.add(intermediaria);
		vagas.getListaUsuarios().add(intermediaria);
	}

	public void removeVaga(Vagas vagas) {
		for (Iterator<Intermediaria> iterator = lista.iterator(); iterator.hasNext();) {
			Intermediaria intermediaria = iterator.next();

			if (intermediaria.getUsuario().equals(this) && intermediaria.getVagas().equals(vagas)) {
				iterator.remove();
				intermediaria.getVagas().getListaUsuarios().remove(intermediaria);
				intermediaria.setUsuario(null);
				intermediaria.setVagas(null);
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Usuario usuario = (Usuario) o;
		return Objects.equals(nome, usuario.nome) && Objects.equals(email, usuario.email)
				&& Objects.equals(senha, usuario.senha) && Objects.equals(datanascimento, usuario.datanascimento)
				&& Objects.equals(gestante, usuario.gestante) && Objects.equals(pcd, usuario.pcd)
				&& Objects.equals(perfil, usuario.perfil);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, email, senha, datanascimento, gestante, pcd, perfil);
	}
	/*
	public Instant getCreatedAt() {
		return createdAt;
	}
	public Instant getUpdateAt() {
		return updateAt;
	}
	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}
	@PreUpdate 
	public void preUpdate() {
		updateAt = Instant.now();	
	}*/
	
}