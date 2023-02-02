package com.baan.ompaloompa.enviodeemailms.services;

import java.time.LocalDateTime;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO.EmailConsultaDTO;
import com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO.EmailMapper;
import com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO.EmailRegistroDTO;
import com.baan.ompaloompa.enviodeemailms.entities.EmailModel;
import com.baan.ompaloompa.enviodeemailms.enuns.Status;
import com.baan.ompaloompa.enviodeemailms.repositories.EmailRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender javaMailSender;

    public EmailConsultaDTO sendEmail(EmailRegistroDTO emailDTO) {
        EmailModel email = EmailMapper.fromDTO(emailDTO);
        email.setDataEnvio(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getRemetente());
            message.setTo(email.getDestinatario());
            message.setSubject(email.getAssunto());
            message.setText(email.getTexto());
            javaMailSender.send(message);

            email.setStatus(Status.ENVIADO);
        } catch (MailException e){
            email.setStatus(Status.ERRO);
        }

        return EmailMapper.fromEntity(emailRepository.save(email));
    }


}
