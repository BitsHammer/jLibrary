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
	@Column(name="role_id")
	private Long id;

	@Column
	private String name;
	
	public Role(){}
	
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
