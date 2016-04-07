/**
 * 
 */
package com.bitshammer.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Bruno
 *
 */
@Entity
public class Categoria {
	
	
	@Id
	@GeneratedValue
	@Column(name="categoria_id")
	private Integer id;
	
	@Column(nullable=false)	
	private String nome;

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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Categoria))
			return false;
		return id.equals(((Categoria)obj).getId());
	}
	

}
