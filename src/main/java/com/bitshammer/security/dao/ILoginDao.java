/**
 * 
 */
package com.bitshammer.security.dao;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.bitshammer.security.model.Role;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public interface ILoginDao {
	
	Usuario findUser(String name, String password) throws LoginException;
	
	List<Role> findRoles(Usuario user);

}
