/**
 * 
 */
package com.bitshammer.test.usuario;

import static org.mockito.Mockito.when;

import javax.security.auth.login.LoginException;

import org.junit.Test;

import com.bitshammer.security.model.Usuario;

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
//		LoginDao dao = mock(LoginDao.class);
//		when(dao.findUser(user.getLogin(), user.getSenha())).thenReturn(user);
		
		
		
	}

}
