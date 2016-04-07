/**
 * 
 */
package com.bitshammer.pedido.bean;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.pedido.Pedido;
import com.bitshammer.pedido.facade.IPedidoFacade;
import com.bitshammer.pedido.facade.PedidoFacade;

/**
 * @author Bruno
 *
 */
public class PedidoBean extends DefaultBean {
	
	private Pedido pedido;
	
	private IPedidoFacade facade;
	
	public PedidoBean() {
		pedido = new Pedido();
		facade = new PedidoFacade();
		
	}
	
	public void efetivarCompra() {
		
	}
	
	public void efetivarSolicitacaoLivros() {
		
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
