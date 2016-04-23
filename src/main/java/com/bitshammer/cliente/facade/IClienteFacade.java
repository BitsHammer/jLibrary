/**
 * 
 */
package com.bitshammer.cliente.facade;

import java.util.List;

import com.bitshammer.cliente.Cliente;

/**
 * @author Bruno
 *
 */
public interface IClienteFacade {

	/**
	 * Cadastra um usuário na base de dados
	 * @param cliente
	 */
	void cadastrarCliente(final Cliente cliente);

	/**
	 * Remove um cliente da base de dados
	 * @param cliente
	 */
	void descadastrarCliente(Cliente cliente);

	/**
	 * Atualiza o cliente
	 * @param cliente
	 */
	void atualizarCliente(Cliente cliente);

	/**
	 * Pesquisa um cliente na base de dados
	 * @param cliente
	 * @return
	 */
	List<Cliente> pesquisarCliente(Cliente cliente);

}
