/**
 * 
 */
package com.bitshammer.security.dao;

import java.io.Serializable;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface ILoginDao {
	
	Usuario findUser(Usuario user) throws LoginException;

}
