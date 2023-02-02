package com.baan.ompaloompa.enviodeemailms.controllers;

import com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO.EmailConsultaDTO;
import com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO.EmailRegistroDTO;
import com.baan.ompaloompa.enviodeemailms.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/emails")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("enviar")
    public ResponseEntity<EmailConsultaDTO> enviarEmail(@RequestBody @Valid EmailRegistroDTO emailRegistroDTO) {
        EmailConsultaDTO emailConsultaDTO = emailService.sendEmail(emailRegistroDTO);
        return new ResponseEntity<>(emailConsultaDTO, HttpStatus.CREATED);
    }

}
