/**
 * 
 */
package com.bitshammer.security.facade;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface ILoginFacade {
	
	void login(Usuario user) throws LoginException;

}
