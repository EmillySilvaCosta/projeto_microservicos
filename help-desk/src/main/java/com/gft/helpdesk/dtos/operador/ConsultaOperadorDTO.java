package com.gft.helpdesk.dtos.operador;

import com.gft.helpdesk.entities.Setor;
import com.gft.helpdesk.enums.NivelEnum;

public class ConsultaOperadorDTO {

	private Long id;
	private String nome;
	private String email;

	private Setor setor;

	private NivelEnum nivel;

	private boolean disponivel;


	public ConsultaOperadorDTO() {

	}

	public ConsultaOperadorDTO(Long id, String nome, String email, Setor setor, NivelEnum nivel, boolean disponivel) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.setor = setor;
		this.nivel = nivel;
		this.disponivel = disponivel;
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

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
