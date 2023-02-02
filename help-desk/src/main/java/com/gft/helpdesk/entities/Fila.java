package com.gft.helpdesk.entities;

import com.gft.helpdesk.enums.NivelEnum;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_fila")
public class Fila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fila_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;
	@Enumerated(EnumType.STRING)
	@Column(name = "fila_nivel")
	private NivelEnum nivel;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "operador_id")
	private List<Operador> operadores;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fila_id")
	private List<Chamado> chamados;

	public Fila() {
	}

	public Fila(Long id, Setor setor, NivelEnum nivel, List<Operador> operadores, List<Chamado> chamados) {
		this.id = id;
		this.setor = setor;
		this.nivel = nivel;
		this.operadores = operadores;
		this.chamados = chamados;
	}

	public Fila(Setor setor, NivelEnum nivel, List<Operador> operadores) {
		this.setor = setor;
		this.nivel = nivel;
		this.operadores = operadores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Operador> getOperadores() {
		return operadores;
	}

	public void setOperadores(List<Operador> operadores) {
		this.operadores = operadores;
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}
}


