/**
 * 
 */
package com.bitshammer.cliente.facade;

import java.util.List;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.cliente.dao.ClienteDao;
import com.bitshammer.cliente.dao.IClienteDao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class ClienteFacade implements IClienteFacade {

	private IClienteDao dao = new ClienteDao();
	
	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.facade.IClienteFacade#cadastrarUsuario(com.bitshammer.cliente.Cliente)
	 */
	@Override
	public void cadastrarCliente(Cliente cliente) {
		dao.persist(cliente);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.facade.IClienteFacade#descadastrarCliente(com.bitshammer.cliente.Cliente)
	 */
	@Override
	public void descadastrarCliente(Cliente cliente) {
		dao.remove(cliente);
	}

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.facade.IClienteFacade#atualizarCliente(com.bitshammer.cliente.Cliente)
	 */
	@Override
	public void atualizarCliente(Cliente cliente) {
		dao.update(cliente);		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.facade.IClienteFacade#pesquisarCliente(com.bitshammer.cliente.Cliente)
	 */
	@Override
	public List<Cliente> pesquisarCliente(Cliente cliente) {		
		return dao.pesquisarCliente(cliente);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.cliente.facade.IClienteFacade#buscarClientePorUsuario(com.bitshammer.security.model.Usuario)
	 */
	@Override
	public Cliente buscarClientePorUsuario(Usuario usuario){
		return dao.findByUser(usuario);
	}

}
