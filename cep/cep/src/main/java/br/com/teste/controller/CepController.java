package br.com.teste.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.teste.model.Cep;
import br.com.teste.utils.Utils;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/cep")
public class CepController {
//	http://localhost:8080/cep/14406515
	static String webService = "http://viacep.com.br/ws/";

	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Cep> findCep(@PathVariable String cep) throws FileNotFoundException {
		Cep endereco = null;
		String url = null;
		String newCep = "";
		
		if (!Utils.validCep(cep)) {
			return new ResponseEntity("CEP Inválido!", HttpStatus.OK);
		}
		;
		try {
			while (newCep != cep) {
				if (!newCep.isEmpty()){
					cep = newCep;
				}
				url = webService + cep + "/json";
				RestTemplate restTemplate = new RestTemplate();
				endereco = restTemplate.getForObject(url, Cep.class);
				
				newCep = Utils.alterCep(endereco, cep);

				if (newCep.equals(cep)) {
					return new ResponseEntity<Cep>(endereco, HttpStatus.OK);
				}
				
			}
			return new ResponseEntity("CEP Inexistente!", HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}