/**
 * 
 */
package com.bitshammer.test.cliente;

import java.util.Calendar;

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
}
