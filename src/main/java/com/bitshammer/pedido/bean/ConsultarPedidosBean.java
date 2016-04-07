package com.bitshammer.pedido.bean;

import java.util.List;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.pedido.Pedido;

public class ConsultarPedidosBean extends DefaultBean{
	
	private Pedido pedidoParam;
		
	public ConsultarPedidosBean() {
		pedidoParam = new Pedido();
	}
	
	public List<Pedido> buscarPedidosPorParametro() {
		return null;
	}

}
