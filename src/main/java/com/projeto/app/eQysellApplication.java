package com.projeto.app;

import com.projeto.app.controllers.EmailController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class eQysellApplication {

@Autowired
private EmailController service;

	public static void main(String[] args) {
		SpringApplication.run(eQysellApplication.class, args);
	}

	/* __________________Teste Email_________________ */

	@EventListener(ApplicationReadyEvent.class)
	public void email(){
		service.enviarEmail("eqysselproj@gmail.com", "Teste...","teste.");
	}

	//############## Teste PJ ###############//

}


	