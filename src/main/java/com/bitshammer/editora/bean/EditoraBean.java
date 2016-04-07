/**
 * 
 */
package com.bitshammer.editora.bean;

import java.util.List;

import com.bitshammer.editora.Editora;
import com.bitshammer.editora.facade.IEditoraFacade;
import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.livro.Livro;
import com.bitshammer.pedido.facade.IPedidoFacade;

/**
 * @author Bruno
 *
 */
public class EditoraBean extends DefaultBean {
	
	private Editora editora;
	
	private List<Editora> listaEditora;
	
	private IPedidoFacade pedidoFacade;
	
	private IEditoraFacade editoraFacade;
	
	public EditoraBean() {
		editora = new Editora();
	}
	
	public String cadastrarEditora(){
		return "";
	}
	
	public void alterarEditora(){
		
	}
	
	public String excluirEditora(){
		return "";
	}
	
	public void listarEditoras(){
		
	}
	
	public List<Livro> listarLivrosPorEditora(){
		return null;
	}
	
	public void solicitarLivrosParaEditora(){
		
	}

	/**
	 * @return the editora
	 */
	public Editora getEditora() {
		return editora;
	}

	/**
	 * @param editora the editora to set
	 */
	public void setEditora(Editora editora) {
		this.editora = editora;
	}

}
