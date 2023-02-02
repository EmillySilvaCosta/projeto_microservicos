package com.gft.helpdesk.dtos.chamado;

import com.gft.helpdesk.dtos.cliente.ClienteConsultaDTO;
import com.gft.helpdesk.dtos.operador.ConsultaOperadorDTO;
import com.gft.helpdesk.dtos.setor.ConsultaSetorDTO;
import com.gft.helpdesk.enums.NivelEnum;
import com.gft.helpdesk.enums.StatusEnum;

import java.time.LocalDateTime;

public class ConsultaChamadoDTO {

	private Long id;
	private ClienteConsultaDTO cliente;
	private ConsultaOperadorDTO operador;
	private String assunto;
	private String texto;
	private LocalDateTime dataAbertura;
	private ConsultaSetorDTO setor;
	private NivelEnum nivel;
	private StatusEnum status;
	private int tempoResposta;

	public ConsultaChamadoDTO() {

	}

	public ConsultaChamadoDTO(Long id, ClienteConsultaDTO cliente, ConsultaOperadorDTO operador, String assunto,
			String texto, LocalDateTime dataAbertura, ConsultaSetorDTO setor, NivelEnum nivel, StatusEnum status, int tempoResposta) {
		this.id = id;
		this.cliente = cliente;
		this.operador = operador;
		this.assunto = assunto;
		this.texto = texto;
		this.dataAbertura = dataAbertura;
		this.setor = setor;
		this.nivel = nivel;
		this.status = status;
		this.tempoResposta = tempoResposta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClienteConsultaDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteConsultaDTO cliente) {
		this.cliente = cliente;
	}

	public ConsultaOperadorDTO getOperador() {
		return operador;
	}

	public void setOperador(ConsultaOperadorDTO operador) {
		this.operador = operador;
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

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public ConsultaSetorDTO getSetor() {
		return setor;
	}

	public void setSetor(ConsultaSetorDTO setor) {
		this.setor = setor;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public int getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(int tempoResposta) {
		this.tempoResposta = tempoResposta;
	}

}
