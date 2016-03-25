/**
 * 
 */
package com.bitshammer.test.usuario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.model.Usuario;
import com.bitshammer.test.WeldJUnit4Runner;

	
/**
 * @author Bruno
 *
 */
@RunWith(WeldJUnit4Runner.class)
public class UsuarioTest {
	
	@Mock
	private ILoginDao dao;
	
	@Inject
	@InjectMocks
	private ILoginFacade facade;
	
	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void lerUsuarioSucesso() throws LoginException{
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
	
	@Test(expected=LoginException.class)
	public void lerUsuarioFalha() throws LoginException{
		Usuario user = new Usuario();
		user.setEmail("bdm2943@gmail.com");
		user.setLogin("bruno");
		user.setSenha("123");
		when(dao.findUser(user)).thenThrow(LoginException.class);
		facade.login(user);
	}

}
