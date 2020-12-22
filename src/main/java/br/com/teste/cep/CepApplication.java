package br.com.teste.cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan

@ComponentScan(basePackages={"br.com.teste.controller"})
public class CepApplication {

	public static void main(String[] args) {

		SpringApplication.run(CepApplication.class, args);
		
	}

}
