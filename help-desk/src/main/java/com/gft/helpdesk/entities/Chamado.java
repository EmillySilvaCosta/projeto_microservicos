package com.gft.helpdesk.entities;

import com.gft.helpdesk.enums.NivelEnum;
import com.gft.helpdesk.enums.StatusEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_chamado")
public class Chamado implements Serializable {

	private static final long serialVersionUID = 684054558089416044L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cham_id")
    private Long id;
	
	@NotNull
    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "op_id")
    private Operador operador;
    
    @NotNull
    @Column(name = "cham_assunto")
    private String assunto;
    
    @NotNull
    @Column(name = "cham_texto", columnDefinition = "TEXT")
    private String texto;
    
    @Column(name = "cham_data_abertura")
    private LocalDateTime dataAbertura;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "set_id")
    private Setor setor;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "cham_nivel")
    private NivelEnum nivel;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "cham_status")
    private StatusEnum status;
    
    @Column(name = "cham_tempo_resposta")
    private int tempoResposta;

    public Chamado() {
    	
    }

    public Chamado(Long id, Cliente cliente, Operador operador, String assunto, String texto,
                   LocalDateTime dataAbertura, Setor setor, NivelEnum nivel, StatusEnum status, int tempoResposta) {
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

    public Chamado(Cliente cliente, String assunto, String texto, LocalDateTime dataAbertura, Setor setor,
                   NivelEnum nivel, StatusEnum status) {
        this.cliente = cliente;
        this.assunto = assunto;
        this.texto = texto;
        this.dataAbertura = dataAbertura;
        this.setor = setor;
        this.nivel = nivel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
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
