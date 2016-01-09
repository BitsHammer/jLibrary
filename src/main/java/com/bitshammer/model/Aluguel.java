package com.bitshammer.model;

import java.util.Date;
import java.util.List;

/**
 * Classe representando um aluguel
 * @author Bruno
 *
 */
public class Aluguel {

	private Long id;

	private List<Livro> livros;

	private Cliente cliente;

	private Date dtRetirada;

	private Date dtEntrega;
	
	private StatusAluguel statusAluguel;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the livros
	 */
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @param livros the livros to set
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
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
	 * @return the dtRetirada
	 */
	public Date getDtRetirada() {
		return dtRetirada;
	}

	/**
	 * @param dtRetirada the dtRetirada to set
	 */
	public void setDtRetirada(Date dtRetirada) {
		this.dtRetirada = dtRetirada;
	}

	/**
	 * @return the dtEntrega
	 */
	public Date getDtEntrega() {
		return dtEntrega;
	}

	/**
	 * @param dtEntrega the dtEntrega to set
	 */
	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	/**
	 * @return the statusAluguel
	 */
	public StatusAluguel getStatusAluguel() {
		return statusAluguel;
	}

	/**
	 * @param statusAluguel the statusAluguel to set
	 */
	public void setStatusAluguel(StatusAluguel statusAluguel) {
		this.statusAluguel = statusAluguel;
	}

}
