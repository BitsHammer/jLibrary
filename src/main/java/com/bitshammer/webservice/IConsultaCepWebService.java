/**
 * 
 */
package com.bitshammer.webservice;

import com.bitshammer.comum.Endereco;

/**
 * @author Bruno
 *
 */
public interface IConsultaCepWebService {
	
	/**
	 * Realiza a consulta de cep
	 * @param cep
	 * @return
	 * @throws CepInvalidoException 
	 * @throws Exception 
	 */
	public Endereco consultarCep(String cep) throws CepInvalidoException, Exception;

}
