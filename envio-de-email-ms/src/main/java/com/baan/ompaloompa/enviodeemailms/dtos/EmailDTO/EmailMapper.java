package com.baan.ompaloompa.enviodeemailms.dtos.EmailDTO;

import com.baan.ompaloompa.enviodeemailms.entities.EmailModel;
import com.baan.ompaloompa.enviodeemailms.enuns.Status;

public class EmailMapper {

    public static EmailModel fromDTO(EmailRegistroDTO emailDTO){
       return new EmailModel(null, "dfbenvioemail@gmail.com", emailDTO.getDestinatario(), emailDTO.getAssunto(),
               emailDTO.getTexto(), null, Status.PROCESSANDO);
    }
    public static EmailConsultaDTO fromEntity(EmailModel email){
        String status = email.getStatus().toString();

        System.out.println("status: " + status);

        return new EmailConsultaDTO(email.getRemetente(), email.getDestinatario(), email.getAssunto(),
                email.getTexto(), email.getDataEnvio(), status);
    }


}
