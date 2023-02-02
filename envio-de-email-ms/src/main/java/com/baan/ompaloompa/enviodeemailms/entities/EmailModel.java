package com.baan.ompaloompa.enviodeemailms.entities;

import com.baan.ompaloompa.enviodeemailms.enuns.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_email")
@Entity
public class EmailModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String remetente;
    @Email
    private String destinatario;
    private String assunto;
    @Column(columnDefinition = "TEXT")
    private String texto;
    @Column(name = "data_envio")
    private LocalDateTime dataEnvio;
    @Enumerated(value = EnumType.STRING)
    private Status status;

}
