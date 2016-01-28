/**
 * 
 */
package com.bitshammer.security.facade;

import java.io.Serializable;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface ILoginFacade extends Serializable {
	
	void login(Usuario user) throws LoginException;

}
