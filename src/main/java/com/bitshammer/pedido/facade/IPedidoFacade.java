/**
 * 
 */
package com.bitshammer.pedido.facade;

import java.util.List;

import com.bitshammer.pedido.Pedido;

/**
 * @author Bruno
 *
 */
public interface IPedidoFacade {
	
	
	public Pedido efetivarCompra(Pedido pedido);
	
	public Pedido efetivarSolicitacaoLivros(Pedido pedido);
	
	public List<Pedido> buscarPorHistoricoDePedidos(Pedido pedido);

}
