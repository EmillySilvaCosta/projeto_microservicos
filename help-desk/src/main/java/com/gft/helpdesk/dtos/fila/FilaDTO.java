package com.gft.helpdesk.dtos.fila;

import com.gft.helpdesk.dtos.chamado.ConsultaChamadoDTO;
import com.gft.helpdesk.dtos.operador.ConsultaOperadorDTO;
import com.gft.helpdesk.dtos.setor.ConsultaSetorDTO;
import com.gft.helpdesk.enums.NivelEnum;

import java.util.List;

public class FilaDTO {

	private Long id;
	private ConsultaSetorDTO setor;
	private NivelEnum nivel;
	private List<ConsultaOperadorDTO> operadores;
	private List<ConsultaChamadoDTO> chamados;

	public FilaDTO() {
	}

	public FilaDTO(Long id, ConsultaSetorDTO setor, NivelEnum nivel,
				   List<ConsultaOperadorDTO> operadores, List<ConsultaChamadoDTO> chamados) {
		this.id = id;
		this.setor = setor;
		this.nivel = nivel;
		this.operadores = operadores;
		this.chamados = chamados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<ConsultaOperadorDTO> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<ConsultaOperadorDTO> operadores) {
		this.operadores = operadores;
	}

	public List<ConsultaChamadoDTO> getChamados() {
		return chamados;
	}

	public void setChamados(List<ConsultaChamadoDTO> chamados) {
		this.chamados = chamados;
	}
}
