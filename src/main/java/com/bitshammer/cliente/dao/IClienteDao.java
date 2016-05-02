/**
 * 
 */
package com.bitshammer.cliente.dao;

import java.util.List;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface IClienteDao {
	
	/**
	 * Grava um cliente na base dados
	 * @param cliente
	 */
	void persist(Cliente cliente);
	
	/**
	 * Atualiza um cliente na base dados
	 * @param cliente
	 */
	void update(Cliente cliente);

	/**
	 * Remove um cliente da base de dados
	 * @param cliente
	 */
	void remove(Cliente cliente);

	/**
	 * Encontra um cliente de um usuário
	 * @param usuario Usuário
	 * @return Cliente
	 */
	Cliente findByUser(Usuario usuario);

	/**
	 * Pesquisa um cliente na base de dados
	 * @param cliente
	 * @return Lista de cliente
	 */
	List<Cliente> pesquisarCliente(Cliente cliente);

}
