package com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailRegistroDTO {

    @NotBlank
    @Email
    private String destinatario;
    @NotBlank
    private String assunto;
    @NotBlank
    private String texto;

}
