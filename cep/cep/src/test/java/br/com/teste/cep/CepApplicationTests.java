package br.com.teste.cep;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.WebApplicationContext;


@SpringBootTest
class CepApplicationTests {
	@Autowired WebApplicationContext wac; 
    @Autowired MockHttpServletRequest request;

	@Test
    public void testFoundFindEndereco() throws Exception {
      
        
    }

}
