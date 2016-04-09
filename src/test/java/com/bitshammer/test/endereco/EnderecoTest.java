package com.bitshammer.test.endereco;

import org.junit.Test;

import com.bitshammer.webservice.CepInvalidoException;
import com.bitshammer.webservice.ConsultaCepWebService;
import com.bitshammer.webservice.IConsultaCepWebService;

/**
 * 
 * @author Bruno
 *
 */
public class EnderecoTest {
	
	private IConsultaCepWebService webService = new ConsultaCepWebService();
	
	@Test
	public void CepExistente() throws CepInvalidoException, Exception{
		webService.consultarCep("03805090");
	}
	
	@Test(expected=CepInvalidoException.class)
	public void CepInexistente() throws CepInvalidoException, Exception{
		webService.consultarCep("99999999");
	}
	
	@Test(expected=Exception.class)
	public void CepErro() throws CepInvalidoException, Exception{
		webService.consultarCep(null);
	}

}
