package com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailConsultaDTO {

    private String remetente;
    private String destinatario;
    private String assunto;
    private String texto;
    private LocalDateTime dataEnvio;
    private String status;

}
