package br.com.teste.cep;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import br.com.teste.model.Cep;
import br.com.teste.utils.Utils;


@SpringBootTest
class CepApplicationTests {

	@Test
    public void testValidCep() throws Exception {
		//O metodo validCep não deve conter caracteres não numericos, e deve conter oito caracteres
		//Esses oito caracteres não devem ser todos "0"
		
		assertFalse(Utils.validCep("A"));
		
		assertFalse(Utils.validCep("0"));
		
		assertFalse(Utils.validCep("1"));
		
		assertFalse(Utils.validCep("1234567"));

		assertFalse(Utils.validCep("1234567A"));
		
		assertFalse(Utils.validCep("00000000"));
		
		assertTrue(Utils.validCep("14406515"));

		assertFalse(Utils.validCep("14406-515"));

		assertTrue(Utils.validCep("12345678"));

		assertTrue(Utils.validCep("00000001"));       
        
    }
	
	@Test
	public void testAlterCep() throws Exception {
		//O metodo AlterCep deve alterar um numero direita para esquerda que seja diferente de zero por 0 
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
	
	

}
