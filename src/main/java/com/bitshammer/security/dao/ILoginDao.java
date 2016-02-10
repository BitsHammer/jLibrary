/**
 * 
 */
package com.bitshammer.security.dao;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface ILoginDao {
	
	Usuario findUser(Usuario user) throws LoginException;
	
	void persist(final Usuario user);

}
