/**
 * 
 */
package com.bitshammer.pedido;

/**
 * Status do pedido
 * @author Bruno
 *
 */
public enum StatusPedido {
	
	RECEBIDO("Recebido"),	
	APROVADO("Aprovado"),
	PREPARADO("Preparando pedido"),
	EM_ROTA("Rota de entrega"),
	ENTREGUE("Entrege"),
	CANCELADO("Cancelado");
	
	/**
	 * Status do pedido
	 */
	private String status;

	/**
	 * Construtor
	 * @param status
	 */
	private StatusPedido(String status) {
		this.status = status;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return status;
	}

}
