/**
 * 
 */
package com.bitshammer.editora.facade;

import java.util.List;

import com.bitshammer.editora.Editora;
import com.bitshammer.livro.Livro;
import com.bitshammer.pedido.Pedido;

/**
 * @author Bruno
 *
 */
public interface IEditoraFacade {
	
public void cadastrarEditora(Editora editora);
	
	public void alterarEditora(Editora editora);
	
	public void excluirEditora(Editora editora);
	
	public List<Editora> listarEditoraPorParametros(Editora editora);
	
	public List<Livro> listarLivrosPorEditora(Editora editora);
	
	public Pedido solicitarLivrosParaEditora();
		

}
