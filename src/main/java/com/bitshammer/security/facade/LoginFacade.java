package com.bitshammer.security.facade;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade{

	
	
	@Inject
	private ILoginDao dao;
	
	@Override
	public Usuario login(Usuario user) throws LoginException {
		return dao.findUser(user);
	}

}
