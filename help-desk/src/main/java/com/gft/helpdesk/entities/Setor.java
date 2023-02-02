package com.gft.helpdesk.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_setor")
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "setor_id")
	private Long id;
	@Column(name = "setor_nome")
	private String nome;

	public Setor() {
	}

	public Setor(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Setor(String nome) {
		this.nome = nome;
	}

	public Setor(Long id) {
		this.id = id;
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

}
