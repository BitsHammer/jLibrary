/**
 * 
 */
package com.bitshammer.livro;

/**
 * @author Bruno
 *
 */
public enum Categoria {
	
	TERROR(1,"Terror"),
	PAIXAO(2,"Paixao");
	
	private String nome;
	
	private Integer id;
	

	public String getNome() {
		return nome;
	}

	private Categoria(Integer id, String nome) {
		this.id =id;
		this.nome = nome;
	}
	
	public static Categoria byId(int id){
		for(Categoria categoria : values()){
			if(categoria.getId()==id){
				return categoria;
			}
		}
		return null;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

}
