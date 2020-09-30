package br.com.teste.cep;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import br.com.teste.model.Cep;
import br.com.teste.utils.Utils;

@WebMvcTest
class CepApplicationTests {

	@Test
	public void testValidCepFalse() throws Exception {
		// O metodo validCep retorna False caso o cep informado:
		// * não tenha 8 caracteres.
		// * contenha algum caracter não numérico
		// * seja igual à "00000000"

		assertFalse(Utils.validCep("A"));

		assertFalse(Utils.validCep("0"));

		assertFalse(Utils.validCep("1"));

		assertFalse(Utils.validCep("1234567"));

		assertFalse(Utils.validCep("1234567A"));

		assertFalse(Utils.validCep("00000000"));

		assertFalse(Utils.validCep("14406-515"));

	}

	@Test
	public void testValidCepTrue() throws Exception {
		// O metodo validCep retorna True caso o cep Informado:
		// tenha oito caracteres não numerico e seja diferente de "00000000"
		assertTrue(Utils.validCep("14406515"));

		assertTrue(Utils.validCep("12345678"));

		assertTrue(Utils.validCep("00000001"));

	}

	@Test
	public void testAlterCep() throws Exception {
		// O metodo AlterCep deve alterar um numero direita para esquerda que seja
		// diferente de zero por por zero
		// por exemplo se for 99999999 deverá alterar e retornar 99999990
		// caso seja informado algum cep considerado invalido pela validCep, esse medodo
		// irá retornar "00000000"
		String cep = "99999999";
		Cep endereco = new Cep();
		assertTrue(Utils.alterCep(endereco, cep).equals("99999990"));

		cep = "99999990";
		assertTrue(Utils.alterCep(endereco, cep).equals("99999900"));

		cep = "05005000";
		assertTrue(Utils.alterCep(endereco, cep).equals("05000000"));

		cep = "90000000";
		assertTrue(Utils.alterCep(endereco, cep).equals("00000000"));

		cep = "A";
		assertTrue(Utils.alterCep(endereco, cep).equals("00000000"));

		cep = "A";
		assertFalse(Utils.alterCep(endereco, cep).equals("14406-515"));

		cep = "1234567";
		assertTrue(Utils.alterCep(endereco, cep).equals("00000000"));

		cep = "1234567A";
		assertTrue(Utils.alterCep(endereco, cep).equals("00000000"));

	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindCepValid() throws Exception {
		// chamada da api em um cep válido, deverá retornar o status ok, e o endereço CEP informado
		mockMvc.perform(MockMvcRequestBuilders.get("/cep/14406515")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(
						"{\"cep\":\"14406-515\",\"logradouro\":\"Rua Alfredo Casale\",\"bairro\":\"Vila Rezende\",\"localidade\":\"Franca\",\"uf\":\"SP\"}"));
	}

	@Test
	public void testFindCepValidAlterCep() throws Exception {
		// chamada da api em um cep válido, deverá retornar o status ok, e o endereço CEP 14406500, pois ao não encontrar o 14406501 
		// a api irá alterar o cep para 14406500 e encontrar um endereço
		mockMvc.perform(MockMvcRequestBuilders.get("/cep/14406501")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(
						"{\"cep\":\"14406-500\",\"logradouro\":\"Rua Ovídio Vanini\",\"bairro\":\"Jardim Dermínio\",\"localidade\":\"Franca\",\"uf\":\"SP\"}"));

	}
	@Test
	public void testFindCepInvalid() throws Exception {
		// chamada da api passando uma letra, fazendo retornar um bad request e a
		// mensagem de "CEP Inválido!"
		mockMvc.perform(MockMvcRequestBuilders.get("/cep/a")).andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content().string("CEP Inválido!"));

	}

	@Test
	public void testFindCepInalidLenght() throws Exception {
		// chamada da api passando um CEP com menos de 8 caracteres, fazendo retornar um
		// bad request e a mensagem de "CEP Inválido!"
		mockMvc.perform(MockMvcRequestBuilders.get("/cep/1440651"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.content().string("CEP Inválido!"));

	}

	@Test
	public void testFindCepNotFound() throws Exception {
		// chamada passando um parametro que não irá encontrar o CEP, deve retornar um
		// not found e a mensagem "CEP Inexistente!"
		mockMvc.perform(MockMvcRequestBuilders.get("/cep/00000000"))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.content().string("CEP Inexistente!"));
	}

	@Test
	public void testFindCepAlterNotFound() throws Exception {
		// chamada passando um parametro que não irá encontrar o CEP, deve retornar um
		// not found e a mensagem "CEP Inexistente!"
		// a diferença do teste acima é que os quatro "9" da direita será trocado por
		// "0" até que fique "00000000"
		mockMvc.perform(MockMvcRequestBuilders.get("/cep/00009999"))
				.andExpect(MockMvcResultMatchers.status().isNotFound())
				.andExpect(MockMvcResultMatchers.content().string("CEP Inexistente!"));

	}

}
