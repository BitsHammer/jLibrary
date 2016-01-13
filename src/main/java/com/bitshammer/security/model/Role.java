/**
 * 
 */
package com.bitshammer.security.model;

import java.security.Principal;

/**
 * @author Bruno
 *
 */
public class Role implements Principal {

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
