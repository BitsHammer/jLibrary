/**
 * 
 */
package com.bitshammer.promocao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * Classe representando uma promoção
 * @author Bruno
 *
 */
public class Promocao {
	
	/**
	 * ID
	 */
	@Id
	@GeneratedValue
	@Column(name="promocao_id")
	private Integer id;
	
	/**
	 * Data inicial
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtInicial;
	
	/**
	 * Data final
	 */
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtFinal;
	
	/**
	 * Descricao
	 */
	@Column
	private String descricao;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the dtInicial
	 */
	public Date getDtInicial() {
		return dtInicial;
	}

	/**
	 * @param dtInicial the dtInicial to set
	 */
	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}

	/**
	 * @return the dtFinal
	 */
	public Date getDtFinal() {
		return dtFinal;
	}

	/**
	 * @param dtFinal the dtFinal to set
	 */
	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		return id.equals(((Promocao)obj).getId());
	}

}
