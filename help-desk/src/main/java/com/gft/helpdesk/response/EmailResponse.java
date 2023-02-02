package com.gft.helpdesk.response;

import java.time.LocalDateTime;

public class EmailResponse {

    private String remetente;
    private String destinatario;
    private String assunto;
    private String texto;
    private LocalDateTime dataEnvio;
    private String status;

    public EmailResponse() {
    }

    public EmailResponse(String remetente, String destinatario, String assunto, String texto, LocalDateTime dataEnvio,
                         String status) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
        this.status = status;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
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

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
