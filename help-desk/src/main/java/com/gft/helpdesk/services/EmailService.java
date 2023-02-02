package com.gft.helpdesk.services;

import com.gft.helpdesk.request.EmailRequest;

public interface EmailService {

    void enviarEmail(EmailRequest emailRequest);
}
