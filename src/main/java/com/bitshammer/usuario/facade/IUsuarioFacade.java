/**
 * 
 */
package com.bitshammer.usuario.facade;

import java.util.List;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface IUsuarioFacade {

	/**
	 * Cadastra um usu�rio na base de dados
	 * @param cliente
	 */
	void cadastrarUsuario(final Usuario usuario);

	/**
	 * Altera um usu�rio na base de dados
	 * @param usu�rio
	 */
	void alterarUsuario(final Usuario usuario);
	
	/**
	 * Remove um usu�rio da base de dados
	 * @param usuario
	 */
	void excluirUsuario(final Usuario usuario);
	
	/**
	 * Procura um usu�rio conforme os par�metros passados
	 * @param usuario
	 * @return
	 */
	List<Usuario> procurarPorParametros(final Usuario usuario);

}
