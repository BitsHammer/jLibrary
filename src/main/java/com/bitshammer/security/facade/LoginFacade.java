package com.bitshammer.security.facade;

import javax.inject.Inject;
import javax.inject.Named;
import javax.security.auth.login.LoginException;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.model.Usuario;

@Named
public class LoginFacade implements ILoginFacade{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8595467789835076412L;
	
	
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
