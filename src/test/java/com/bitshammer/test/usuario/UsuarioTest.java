/**
 * 
 */
package com.bitshammer.test.usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.security.auth.login.LoginException;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bitshammer.security.dao.impl.LoginDao;
import com.bitshammer.security.facade.LoginFacade;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class UsuarioTest {
	
	@Mock
	private LoginDao dao;
	
	@InjectMocks
	private LoginFacade facade;
	
	@Test
	public void gravarUsuarioSucesso() throws LoginException{
		MockitoAnnotations.initMocks(this);
		Usuario user = new Usuario();
		user.setEmail("bdm2943@gmail.com");
		user.setLogin("bruno");
		user.setSenha("123");
		when(dao.findUser(user)).thenAnswer(new Answer<Usuario>() {

			@Override
			public Usuario answer(InvocationOnMock invocation) throws Throwable {
				Usuario usuario = new Usuario();
				usuario.setId(1l);
				return usuario;
			}
		});
		user = facade.login(user);
		assertEquals(1l, user.getId().longValue());
		
		
		
	}

}
