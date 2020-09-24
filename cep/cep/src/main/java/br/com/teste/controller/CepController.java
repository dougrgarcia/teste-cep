package br.com.teste.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.teste.model.Cep;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/cep")
public class CepController {
//	http://localhost:8080/cep/14406515

	static String webService = "http://viacep.com.br/ws/";

	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Cep> findCep(@PathVariable String cep) throws FileNotFoundException {

		String urlParaChamada = webService + cep + "/json";

		try {
			RestTemplate restTemplate = new RestTemplate();
			Cep endereco = restTemplate.getForObject(urlParaChamada, Cep.class);

			return new ResponseEntity<Cep>(endereco, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}