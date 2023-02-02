package com.gft.helpdesk.entities;

import com.gft.helpdesk.enums.NivelEnum;

import javax.persistence.*;

@Entity
@Table(name = "tb_operador")
public class Operador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "op_id")
	private Long id;

	@Column(name = "op_nome")
	private String nome;

	@Column(name = "op_email")
	private String email;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;

	@Enumerated(EnumType.STRING)
	@Column(name = "fila_nivel")
	private NivelEnum nivel;

	@Column(name = "op_disponivel")
	private boolean disponivel;

	public Operador() {

	}

	public Operador(Long id, String nome, String email, Setor setor, NivelEnum nivel, boolean disponivel) {
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
