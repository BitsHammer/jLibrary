/**
 * 
 */
package com.bitshammer.security.model;

import java.security.Principal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Bruno
 *
 */
@Entity
public class Role implements Principal {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	public Role(String name) {
		super();
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {		
		return name;
	}

}
