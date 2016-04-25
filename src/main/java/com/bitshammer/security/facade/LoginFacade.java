package com.bitshammer.security.facade;

import javax.security.auth.login.LoginException;

import com.bitshammer.cliente.dao.ClienteDao;
import com.bitshammer.cliente.dao.IClienteDao;
import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.dao.LoginDao;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade {

	private ILoginDao dao = new LoginDao();
	
	private IClienteDao clienteDao = new ClienteDao();

	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.security.facade.ILoginFacade#login(com.bitshammer.security.model.Usuario)
	 */
	@Override
	public Usuario login(final Usuario usuario) throws LoginException {
		return dao.findUser(usuario);
	}
	

}
