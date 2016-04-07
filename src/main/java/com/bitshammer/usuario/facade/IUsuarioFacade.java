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
	 * Cadastra um usuário na base de dados
	 * @param cliente
	 */
	void cadastrarUsuario(final Usuario usuario);

	/**
	 * Altera um usuário na base de dados
	 * @param usuário
	 */
	void alterarUsuario(final Usuario usuario);
	
	/**
	 * Remove um usuário da base de dados
	 * @param usuario
	 */
	void excluirUsuario(final Usuario usuario);
	
	/**
	 * Procura um usuário conforme os parâmetros passados
	 * @param usuario
	 * @return
	 */
	List<Usuario> procurarPorParametros(final Usuario usuario);

}
