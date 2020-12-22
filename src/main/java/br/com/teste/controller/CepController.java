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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.FileNotFoundException;

@Api(value = "Teste CEP")
@RestController
@RequestMapping("/cep")
public class CepController {
	// API Get de consumo do Web Service VIACEP, onde é passado o "CEP" e obtem um json com o Endereço e com o status 200 - OK
	// Se o CEP informado não tiver 8 caracteres ou tiver algum caracter não numerico, será retornado a mensagem de "CEP Invalido!" com o status 400 - BAD_REQUEST"
	// Em caso de não encontrar retorna uma mensagem "CEP Inválido!" com o status 404 - NOT_FOUND 
	// exemplo de chamada: http://localhost:8080/cep/14406515
	static String webService = "http://viacep.com.br/ws/";

	@ApiOperation(value = "Retorna CEP em formato Json")
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public ResponseEntity<Cep> findCep(@PathVariable String cep) throws FileNotFoundException {
		Cep endereco = null;
		String url = null;
		String newCep = "";

		if (!Utils.validCep(cep)) {
			return new ResponseEntity("CEP Inválido!", HttpStatus.BAD_REQUEST);
		};
		
		try {
			while ((!newCep.equals(cep))) {
				if (!newCep.isEmpty()) {
					cep = newCep;
				}
				
				url = webService + cep + "/json";
				RestTemplate restTemplate = new RestTemplate();
				endereco = restTemplate.getForObject(url, Cep.class);

				newCep = Utils.alterCep(endereco, cep);
				
				if (newCep.equals(cep) && (!newCep.equals("00000000"))) {
					return new ResponseEntity<Cep>(endereco, HttpStatus.OK);
				}
			}
			return new ResponseEntity("CEP Inexistente!", HttpStatus.NOT_FOUND);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}