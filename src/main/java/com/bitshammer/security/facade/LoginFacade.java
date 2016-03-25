package com.bitshammer.security.facade;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.dao.LoginDao;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade {

	private ILoginDao dao = new LoginDao();

	@Override
	public Usuario login(Usuario user) throws LoginException {
		return dao.findUser(user);
	}

}
