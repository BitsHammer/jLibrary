/**
 * 
 */
package com.bitshammer.cliente.dao;

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
	 * Remove um cliente da base de dados
	 * @param cliente
	 */
	void remove(Cliente cliente);

	/**
	 * Encontra um cliente de um usu�rio
	 * @param usuario Usu�rio
	 * @return Cliente
	 */
	Cliente findByUser(Usuario usuario);

}
