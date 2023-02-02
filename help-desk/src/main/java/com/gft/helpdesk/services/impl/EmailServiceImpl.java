package com.gft.helpdesk.services.impl;

import com.gft.helpdesk.request.EmailRequest;
import com.gft.helpdesk.response.EmailResponse;
import com.gft.helpdesk.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

    @Value("${eureka.instance.hostname}")
    String host;

    @Override
    public void enviarEmail(EmailRequest emailRequest) {
        RestTemplate restTemplate = new RestTemplate();
        String urlApi = "http://" + host + ":8083/envio-de-email-ms/v1/emails/enviar";

        restTemplate.postForObject(urlApi, emailRequest, EmailResponse.class);

    }
}
