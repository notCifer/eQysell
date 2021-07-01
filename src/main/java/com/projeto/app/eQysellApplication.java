package com.projeto.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableSwagger2
public class eQysellApplication {

	public static void main(String[] args) {
		SpringApplication.run(eQysellApplication.class, args);
	}

	/* __________________Teste Email_________________ */

	// @EventListener(ApplicationReadyEvent.class)
	// public void email(){
	// 	service.enviarEmail("eqysselproj@gmail.com", "Teste...","teste.");
	// }

	//############## Teste PJ ###############//

}


	