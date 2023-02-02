package com.gft.helpdesk.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -6191666136583952067L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cli_id")
	private Long id;
	@NotNull
	@Column(name = "cli_nome")
	private String nome;
	@NotNull
	@Email
	@Column(name = "cli_email")
	private String email;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Cliente(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
}
