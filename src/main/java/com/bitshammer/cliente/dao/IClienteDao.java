/**
 * 
 */
package com.bitshammer.cliente.dao;

import com.bitshammer.cliente.Cliente;

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

}
