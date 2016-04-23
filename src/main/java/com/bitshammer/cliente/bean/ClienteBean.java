/**
 * 
 */
package com.bitshammer.cliente.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.cliente.facade.ClienteFacade;
import com.bitshammer.cliente.facade.IClienteFacade;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;
import com.bitshammer.webservice.CepInvalidoException;
import com.bitshammer.webservice.ConsultaCepWebService;
import com.bitshammer.webservice.IConsultaCepWebService;

/**
 * @author Bruno
 *
 */
@ManagedBean
@ViewScoped
public class ClienteBean extends DefaultBean {
	
	/**
	 * Cliente
	 */
	private Cliente cliente;
	
	/**
	 * Facade da classe Cliente
	 */
	private IClienteFacade facade;
	
	/**
	 * WebService de consulta de CEPs
	 */
	private IConsultaCepWebService webService;

	/**
	 * Lista de cliente
	 */
	private List<Cliente> listaClientes;
	
	private Cliente clienteDetalhe;
	
	/**
	 * Construtor
	 */
	public ClienteBean() {
		Cliente clienteAlterar = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("clienteAlterar");
		if(clienteAlterar != null){
			cliente = clienteAlterar;
		}else if(getClienteLogado() != null){
			cliente = getClienteLogado();
		} else {
			cliente = new Cliente();
			Usuario usuario = new Usuario();
			usuario.setTipoUsuario(TipoUsuario.CLIENTE);
			cliente.setUsuario(usuario);
		}
		facade = new ClienteFacade();
		webService = new ConsultaCepWebService();
	}
	
	/**
	 * Cadastra um cliente
	 * @return
	 */
	public String cadastrarCliente(){
		try{
			facade.cadastrarCliente(cliente);
			addMessage("Sucesso", "Cadastro efetivado com sucesso");
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("usuario", cliente.getUsuario());
			session.setAttribute("cliente", cliente);
			return "home";
		}catch(Exception e){
			showErrorMessage("Erro ao efetivar o cadastro!");
			return "";
		}
	}
	
	/**
	 * Cancela o cadastro do cliente
	 * @return
	 */
	public String cancelarCadastro(){
		try{
			facade.descadastrarCliente(cliente);
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.removeAttribute("usuario");
			session.removeAttribute("cliente");
			return "home";
		}catch(Exception e){
			showErrorMessage("Erro ao cancelar cadastro!");
			return "";
		}
	}
	
	public String alterarCadastro(Cliente cliente) throws Exception{
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("clienteAlterar", cliente);
		return "alterarClienteLoader";
	}
	
	/**
	 * Cancela o cadastro do cliente
	 * @return
	 */
	public void cancelarCadastro(Cliente c){
		try{
			facade.descadastrarCliente(c);
			listaClientes.remove(c);
			addMessage("Sucesso", "Cliente descadastrado com sucesso!");
		}catch(Exception e){
			showErrorMessage("Erro ao cancelar cadastro!");
		}
	}
	
	public void pesquisarCliente(){
		try{
			listaClientes = facade.pesquisarCliente(cliente);
			if(listaClientes.isEmpty())
				showErrorMessage("Nenhum cliente encontrado!");
		}catch(Exception e){
			showErrorMessage("Erro ao pesquisar cadastro!");
		}
	}
	
	/**
	 * Cadastra um cliente
	 * @return
	 */
	public void atualizarCliente(){
		try{
			facade.atualizarCliente(cliente);
			addMessage("Sucesso", "Cliente atualizado");
		}catch(Exception e){
			showErrorMessage("Erro ao efetivar o atualização!");
		}
	}
	
	/**
	 * Busca um cep no webService dos correios
	 */
	public void buscarCep(){
		try{
			cliente.setEndereco(webService.consultarCep(cliente.getEndereco().getCep()));
		}catch(CepInvalidoException e){
			showErrorMessage("Cep não encontrado!");
		}catch(Exception e){
			showErrorMessage("Erro ao realizar busca de cep");
		}
	}

	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the listaClientes
	 */
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	/**
	 * @param listaClientes the listaClientes to set
	 */
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * @return the clienteDetalhe
	 */
	public Cliente getClienteDetalhe() {
		return clienteDetalhe;
	}

	/**
	 * @param clienteDetalhe the clienteDetalhe to set
	 */
	public void setClienteDetalhe(Cliente clienteDetalhe) {
		this.clienteDetalhe = clienteDetalhe;
	}

}
