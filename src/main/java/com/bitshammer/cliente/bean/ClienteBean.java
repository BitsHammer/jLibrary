/**
 * 
 */
package com.bitshammer.cliente.bean;

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
	 * Construtor
	 */
	public ClienteBean() {
		if(getClienteLogado() != null){
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

}
