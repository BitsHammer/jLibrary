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
	private String localidade;

	/**
	 * Estado
	 */
	@Column
	private String uf;

	/**
	 * CEP
	 */
	@Column
	private String cep;

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
	public String getLocalidade() {
		return localidade;
	}

	/**
	 * @param cidade
	 *            the cidade to set
	 */
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	/**
	 * @return the estado
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep
	 *            the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

}
