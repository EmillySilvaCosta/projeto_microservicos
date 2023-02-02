package com.baan.ompaloompa.enviodeemailms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class EnvioDeEmailMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioDeEmailMsApplication.class, args);
	}

}
