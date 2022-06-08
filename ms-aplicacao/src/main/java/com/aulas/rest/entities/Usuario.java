package com.aulas.rest.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Usuario() {
		
	}
	
	
}
	
	
	