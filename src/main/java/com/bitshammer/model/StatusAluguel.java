/**
 * 
 */
package com.bitshammer.model;

/**
 * @author Bruno
 *
 */
public enum StatusAluguel {
	
	ABERTO("Aberto"),
	DEVOLVIDO("Devolvido"),
	PRORROGADO("Prorrogado");
	
	private String status;

	private StatusAluguel(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return status;
	}

}
