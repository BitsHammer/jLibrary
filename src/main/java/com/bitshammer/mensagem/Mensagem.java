/**
 * 
 */
package com.bitshammer.mensagem;

import java.util.List;

import com.bitshammer.promocao.Promocao;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class Mensagem {
	
	private String remetente;
	
	private String assunto;
	
	private List<Usuario> destinarios;
	
	private Promocao promocao;

	/**
	 * @return the remetente
	 */
	public String getRemetente() {
		return remetente;
	}

	/**
	 * @param remetente the remetente to set
	 */
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}

	/**
	 * @param assunto the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	/**
	 * @return the destinarios
	 */
	public List<Usuario> getDestinarios() {
		return destinarios;
	}

	/**
	 * @param destinarios the destinarios to set
	 */
	public void setDestinarios(List<Usuario> destinarios) {
		this.destinarios = destinarios;
	}

	/**
	 * @return the promocao
	 */
	public Promocao getPromocao() {
		return promocao;
	}

	/**
	 * @param promocao the promocao to set
	 */
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	

}
