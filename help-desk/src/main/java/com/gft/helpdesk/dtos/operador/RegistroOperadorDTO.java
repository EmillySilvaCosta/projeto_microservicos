package com.gft.helpdesk.dtos.operador;

import com.gft.helpdesk.enums.NivelEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegistroOperadorDTO {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	private Long idSetor;

	@Enumerated(EnumType.STRING)
	private NivelEnum nivel;

	public RegistroOperadorDTO() {

	}

	public RegistroOperadorDTO(String nome, String email, Long idSetor, NivelEnum nivel) {
		this.nome = nome;
		this.email = email;
		this.idSetor = idSetor;
		this.nivel = nivel;
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

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}
}
