/**
 * 
 */
package com.bitshammer.test.usuario;

import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.security.auth.login.LoginException;

import com.bitshammer.dao.DataAccess;
import com.bitshammer.security.dao.impl.LoginDao;
import com.bitshammer.security.model.Usuario;
import com.bitshammer.security.services.LoginBean;

/**
 * @author Bruno
 *
 */
public class UsuarioTeste {
	
	
	
	@Test
	public void gravarUsuarioSucesso() throws LoginException{
		Usuario user = new Usuario();
		user.setEmail("bdm2943@gmail.com");
		user.setLogin("bruno");
		user.setSenha("123");
		LoginDao dao = mock(LoginDao.class);
		when(dao.findUser(user.getLogin(), user.getSenha())).thenReturn(user);
		
		
		
	}

}
