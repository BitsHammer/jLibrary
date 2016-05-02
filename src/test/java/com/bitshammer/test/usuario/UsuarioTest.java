/**
 * 
 */
package com.bitshammer.test.usuario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.security.auth.login.LoginException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.cliente.Sexo;
import com.bitshammer.cliente.facade.ClienteFacade;
import com.bitshammer.cliente.facade.IClienteFacade;
import com.bitshammer.comum.Endereco;
import com.bitshammer.security.facade.ILoginFacade;
import com.bitshammer.security.facade.LoginFacade;
import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class UsuarioTest {


	private ILoginFacade facade = new LoginFacade();

	private static IClienteFacade facadeCliente = new ClienteFacade();

	private static Cliente cliente;

	@BeforeClass
	public static void beforeClass() {
		// Cliente
		cliente = new Cliente();
		cliente.setNome("Bruno");
		cliente.setCpf("43598392869");
		cliente.setDtNascimento(new Calendar.Builder().setDate(1995, 05, 10)
				.build().getTime());
		cliente.setCelular("953200587");
		cliente.setTelefone("29435002");
		cliente.setSexo(Sexo.M);

		// Endereco
		Endereco endereco = new Endereco();
		endereco.setBairro("Parque Boturussu");
		endereco.setCep("03805090");
		endereco.setLocalidade("São Paulo");
		endereco.setComplemento("Proximo a avendia Paranagua");
		endereco.setUf("SP");
		endereco.setNumero(661);

		// Usuario
		Usuario usuario = new Usuario();
		usuario.setEmail("bdm2943@gmail.com");
		usuario.setLogin("bruno");
		usuario.setSenha("12345a");
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);

		cliente.setEndereco(endereco);
		cliente.setUsuario(usuario);

		facadeCliente.cadastrarCliente(cliente);
		System.out.println(cliente);
	}

	@Test
	public void logarUsuarioSucesso() throws LoginException {
		Usuario user = cliente.getUsuario();
		user.setId(null);
		user = facade.login(user);

		assertTrue(user.getId() != null);
	}
	

	@Test(expected = LoginException.class)
	public void lerUsuarioFalha() throws LoginException {
		Usuario user = new Usuario();
		user.setEmail("bdm2943@gmail.com");
		user.setLogin("bruno");
		user.setSenha("123");
		facade.login(user);
	}
	
	public void encontrarClientepeloUsuario() throws LoginException {
		Usuario user = new Usuario();
		user.setEmail("bdm2943@gmail.com");
		user.setLogin("bruno");
		user.setSenha("123");
		Cliente cliente = facadeCliente.buscarClientePorUsuario(user);
		assertNotNull(cliente);
	}
	
	@Test
	public void testarIgualdadeUsuario(){
		Usuario usuario = new Usuario();
		usuario.setId(1);
		Usuario usuario2 = new Usuario();
		usuario2.setId(2);
		assertNotEquals(usuario, usuario2);
		assertNotEquals(usuario, null);
		assertNotEquals(usuario, new Usuario());
		usuario2.setId(1);
		assertEquals(usuario, usuario2);
	}

}
