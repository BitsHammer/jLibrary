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
	
	Usuario findUser(String name, String password) throws LoginException;

}
