package com.aulas.rest.dto;

import java.sql.Date;

import com.aulas.rest.entidades.Usuario;

public class UsuarioDTO {
	private String nome;
	private String email;
	private Date datanascimento;
	private char gestante;
	private char pcd;
	private int id;
	private String perfil;
	

	public UsuarioDTO(int id, String perfil) {
	
		this.id = id;
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}

	public UsuarioDTO() {

	}

	public UsuarioDTO(String nome, String email, Date datanascimento, char gestante, char pcd, int id, String perfil) {

		this.nome = nome;
		this.email = email;
		this.datanascimento = datanascimento;
		this.gestante = gestante;
		this.pcd = pcd;
		this.id = id;
		this.perfil = perfil;
	}

	public UsuarioDTO(Usuario usuario) {

		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.datanascimento = usuario.getDatanascimento();
		this.gestante = usuario.getGestante();
		this.pcd = usuario.getPcd();
		this.id = usuario.getId();
		this.perfil = usuario.getPerfil();	}

}