package com.cancino.sistemaalmacenspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SistemaAlmacenSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaAlmacenSpringApplication.class, args);
	}

}
