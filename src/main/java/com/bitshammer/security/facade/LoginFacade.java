package com.bitshammer.security.facade;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade{

	
	
	@Inject
	private ILoginDao dao;
	
	@Override
	public void login(Usuario user) throws LoginException {
		dao.findUser(user.getName(), user.getSenha());
		
	}


	/**
	 * @return the dao
	 */
	public ILoginDao getDao() {
		return dao;
	}


	/**
	 * @param dao the dao to set
	 */
	public void setDao(ILoginDao dao) {
		this.dao = dao;
	}

}
