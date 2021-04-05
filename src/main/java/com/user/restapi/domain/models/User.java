package com.user.restapi.domain.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="TB_USER")

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@NotBlank
	@Column( name = "nome")
	private String nome;
	
	@NotNull
	@NotBlank
	@Email
	@Column( name= "email")
	private String email;
	/*
	@NotNull
	@NotBlank
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column( name= "password")
	private String password;
	*/
	@NotNull
	@NotBlank
	@Column( name = "endereco")
	private String endereco;
	
	@NotNull
	@NotBlank
	@Column( name = "cidade")
	private String cidade;
	
	@Column(name= "createdAt")
	private LocalDateTime createdAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	

}
