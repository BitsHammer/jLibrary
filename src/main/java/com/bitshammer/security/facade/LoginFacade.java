package com.bitshammer.security.facade;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.dao.LoginDao;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade {

	private ILoginDao dao = new LoginDao();
	
	/*
	 * (non-Javadoc)
	 * @see com.bitshammer.security.facade.ILoginFacade#login(com.bitshammer.security.model.Usuario)
	 */
	@Override
	public Usuario login(final Usuario usuario) throws LoginException {
		return dao.findUser(usuario);
	}
	

}
