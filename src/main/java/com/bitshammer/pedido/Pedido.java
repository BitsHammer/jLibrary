/**
 * 
 */
package com.bitshammer.pedido;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bitshammer.comum.Endereco;
import com.bitshammer.security.model.Usuario;

/**
 * Pedido 
 * @author Bruno
 *
 */
@Entity
public class Pedido {
	
	/**
	 * ID do pedido
	 */
	@Id
	@GeneratedValue
	@Column(name="pedido_id")
	private Long id;
	
	/**
	 * Lista de itens do pedido
	 */
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pedido_id")
	private List<Item> listaItens;
	
	/**
	 * Usuario do pedido
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id")
	private Usuario usuario;
	
	/**
	 * Status do pedido
	 */
	@Enumerated(EnumType.ORDINAL)
	private StatusPedido statusPedido;
	
	/**
	 * Endereco de entrega
	 */
	@Embedded
	private Endereco enderecoEntrega;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the listaItens
	 */
	public List<Item> getListaItens() {
		return listaItens;
	}

	/**
	 * @param listaItens the listaItens to set
	 */
	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the statusPedido
	 */
	public StatusPedido getStatusPedido() {
		return statusPedido;
	}

	/**
	 * @param statusPedido the statusPedido to set
	 */
	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}
	
	/**
	 * Calcula o preco total
	 */
	public double calcularValorPedido(){
		return listaItens.stream().mapToDouble(Item::valorTotal).sum();
	}

	/**
	 * @return the enderecoEntrega
	 */
	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	/**
	 * @param enderecoEntrega the enderecoEntrega to set
	 */
	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	

}
