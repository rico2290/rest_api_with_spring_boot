/**
 * 
 */
package com.users.restapi.models;

/**
 * @author rico22
 *
 */

import java.io.Serializable;
import java.time.LocalDate;
//import java.util.List;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="TB_USER")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column( name = "id")
	private long id;
	
	@NotNull
	@NotBlank
	@Column( name = "name")
	private String name;
	
	@NotNull
	@NotBlank
	@Email
	@Column( name= "email")
	private String email;
	
	@NotNull
	@NotBlank
	//@Min(5)
	@JsonProperty(access = Access.WRITE_ONLY)
	@Column( name= "password")
	private String password;
	
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
	
	
	/*@OneToMany(mappedBy="user")
	private List<FileUpload> files;
	*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime localDateTime) {
		this.createdAt = localDateTime;
	}
	
	/*
	public List<FileUpload> getFiles() {
		return files;
	}
	

	public void setFiles(List<FileUpload> files) {
		this.files = files;
	}
	*/
	public User() {
		// TODO Auto-generated constructor stub
	}

}

