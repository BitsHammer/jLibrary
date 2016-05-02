/**
 * 
 */
package com.bitshammer.test.cliente;


import static org.junit.Assert.*; 
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.cliente.Sexo;
import com.bitshammer.cliente.facade.ClienteFacade;
import com.bitshammer.cliente.facade.IClienteFacade;
import com.bitshammer.comum.Endereco;
import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class ClienteTest {
	
	private IClienteFacade facade = new ClienteFacade();
	
	/**
	 * Teste do cadastor de cliente
	 */
	@Test
	public void cadastrarClienteSucesso(){
		
		//Cliente
		Cliente cliente = new Cliente();
		cliente.setNome("Bruno");
		cliente.setCpf("43598392869");
		cliente.setDtNascimento(new Calendar.Builder().setDate(1995, 05, 10).build().getTime());
		cliente.setCelular("953200587");
		cliente.setTelefone("29435002");
		cliente.setSexo(Sexo.M);
		
		//Endereco
		Endereco endereco = new Endereco();
		endereco.setBairro("Parque Boturussu");
		endereco.setCep("03805090");
		endereco.setLocalidade("São Paulo");
		endereco.setComplemento("Proximo a avendia Paranagua");
		endereco.setUf("SP");
		endereco.setNumero(661);
		endereco.setLogradouro("Rua Dario Costa Mattos");
		
		//Usuario
		Usuario usuario = new Usuario();
		usuario.setEmail("bdm2943@gmail.com");
		usuario.setLogin("bruno");
		usuario.setSenha("12345a");
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);
		
		cliente.setEndereco(endereco);
		cliente.setUsuario(usuario);
		
		facade.cadastrarCliente(cliente);
	}
	
	@Test
	public void excluirClienteSucesso(){
		Cliente cliente = new Cliente();
		cliente.setNome("Bruno");
		cliente.setCpf("43598392869");
		cliente.setDtNascimento(new Calendar.Builder().setDate(1995, 05, 10).build().getTime());
		cliente.setCelular("953200587");
		cliente.setTelefone("29435002");
		cliente.setSexo(Sexo.F);
		
		//Endereco
		Endereco endereco = new Endereco();
		endereco.setBairro("Parque Boturussu");
		endereco.setCep("03805090");
		endereco.setLocalidade("São Paulo");
		endereco.setComplemento("Proximo a avendia Paranagua");
		endereco.setUf("SP");
		endereco.setNumero(661);
		
		//Usuario
		Usuario usuario = new Usuario();
		usuario.setEmail("bdm2943@gmail.com");
		usuario.setLogin("bruno");
		usuario.setSenha("12345a");
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);
		
		cliente.setEndereco(endereco);
		cliente.setUsuario(usuario);
		
		facade.cadastrarCliente(cliente);
		facade.descadastrarCliente(cliente);
	}
	
	@Test
	public void atualizarCliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Bruno");
		cliente.setCpf("43598392869");
		cliente.setDtNascimento(new Calendar.Builder().setDate(1995, 05, 10).build().getTime());
		cliente.setCelular("953200587");
		cliente.setTelefone("29435002");
		cliente.setSexo(Sexo.F);
		
		//Endereco
		Endereco endereco = new Endereco();
		endereco.setBairro("Parque Boturussu");
		endereco.setCep("03805090");
		endereco.setLocalidade("São Paulo");
		endereco.setComplemento("Proximo a avendia Paranagua");
		endereco.setUf("SP");
		endereco.setNumero(661);
		
		//Usuario
		Usuario usuario = new Usuario();
		usuario.setEmail("bdm2943@gmail.com");
		usuario.setLogin("bruno");
		usuario.setSenha("12345a");
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);
		
		cliente.setEndereco(endereco);
		cliente.setUsuario(usuario);
		
		facade.cadastrarCliente(cliente);
		facade.atualizarCliente(cliente);
		
	}
	
	/**
	 * Pesquisa um cliente na base
	 */
	@Test
	public void pesquisarCliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Bruno");
		cliente.setCpf("43598392869");
		cliente.setDtNascimento(new Calendar.Builder().setDate(1995, 05, 10).build().getTime());
		cliente.setCelular("953200587");
		cliente.setTelefone("29435002");
		cliente.setSexo(Sexo.F);
		
		//Endereco
		Endereco endereco = new Endereco();
		endereco.setBairro("Parque Boturussu");
		endereco.setCep("03805090");
		endereco.setLocalidade("São Paulo");
		endereco.setComplemento("Proximo a avendia Paranagua");
		endereco.setUf("SP");
		endereco.setNumero(661);
		
		//Usuario
		Usuario usuario = new Usuario();
		usuario.setEmail("bdm2943@gmail.com");
		usuario.setLogin("bruno");
		usuario.setSenha("12345a");
		usuario.setTipoUsuario(TipoUsuario.CLIENTE);
		
		cliente.setEndereco(endereco);
		cliente.setUsuario(usuario);
		
		facade.cadastrarCliente(cliente);
		cliente = new Cliente();
		cliente.setNome("Bruno");
		List<Cliente> lista = facade.pesquisarCliente(cliente);
		assertNotEquals(0, lista.size());
	}
	
	@Test
	public void pesquisarVazio(){
		Cliente cliente = new Cliente();
		cliente.setNome("asdihfoaudhf");
		List<Cliente> lista = facade.pesquisarCliente(cliente);
		assertEquals(0, lista.size());
	}
	
	@Test
	public void testarIgualdadeCliente(){
		Cliente cliente = new Cliente();
		cliente.setId(1l);
		Cliente cliente2 = new Cliente();
		cliente2.setId(2l);
		assertNotEquals(cliente, cliente2);
		assertNotEquals(cliente, null);
		assertNotEquals(cliente, new Usuario());
		cliente2.setId(1l);
		assertEquals(cliente, cliente2);
	}
	
}
