package com.bitshammer.security.facade.impl;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.model.Usuario;

class LoginFacade implements ILoginFacade{

	
	
	@Inject
	private ILoginDao dao;
	
	@Override
	public Usuario login(Usuario user) throws LoginException {
		return dao.findUser(user);
	}

}
