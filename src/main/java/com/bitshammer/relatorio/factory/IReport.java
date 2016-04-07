/**
 * 
 */
package com.bitshammer.relatorio.factory;

import java.io.File;

/**
 * @author Bruno
 *
 */
public interface IReport {
	
	
	void buscarPorDados();
	
	File gerarArquivo();

}
