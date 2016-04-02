package com.bitshammer.comum;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe que mapeia um endereco
 * 
 * @author Bruno
 *
 */
@Embeddable
public class Endereco {

	/**
	 * Logradouro
	 */
	@Column
	private String logradouro;

	/**
	 * Número
	 */
	@Column
	private Integer numero;

	/**
	 * Complemento
	 */
	@Column
	private String complemento;

	/**
	 * Bairro
	 */
	@Column
	private String bairro;

	/**
	 * Cidade
	 */
	@Column
	private String cidade;

	/**
	 * Estado
	 */
	@Column
	private String estado;

	/**
	 * CEP
	 */
	@Column
	private Long cep;

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro
	 *            the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento
	 *            the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro
	 *            the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cep
	 */
	public Long getCep() {
		return cep;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(Long cep) {
		this.cep = cep;
	}

}
