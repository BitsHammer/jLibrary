/**
 * 
 */
package com.bitshammer.pedido;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.bitshammer.security.model.Usuario;

/**
 * Pedido 
 * @author Bruno
 *
 */
public class Pedido {
	
	/**
	 * ID do pedido
	 */
	@Id
	@GeneratedValue
	@Column(name="pedido_id")
	private Long id;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
	      name="pedido_item",
	      joinColumns={@JoinColumn(name="pedido_id", referencedColumnName="item_id")},
	      inverseJoinColumns={@JoinColumn(name="item_id", referencedColumnName="item_id")})
	private List<Item> listaItens;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id")
	private Usuario usuario;
	
	private StatusPedido statusPedido;
	
	

}
