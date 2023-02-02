package com.gft.helpdesk.dtos.chamado;

import javax.validation.constraints.NotBlank;

public class RegistroChamadoDTO {

	@NotBlank(message = "Nome do Cliente deve ser preenchido")
	private String nomeCliente;

	@NotBlank(message = "Email do Cliente deve ser preenchido")
	private String emailCliente;

	@NotBlank(message = "Assunto deve ser preenchido")
	private String assunto;

	@NotBlank(message = "Texto deve ser preenchido")
	private String texto;

	@NotBlank(message = "Setor deve ser preenchido")
	private Long idSetor;

	public RegistroChamadoDTO() {

	}

	public RegistroChamadoDTO(String nomeCliente, String emailCliente, String assunto, String texto, Long idSetor) {
		this.nomeCliente = nomeCliente;
		this.emailCliente = emailCliente;
		this.assunto = assunto;
		this.texto = texto;
		this.idSetor = idSetor;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long idSetor) {
		this.idSetor = idSetor;
	}
}
