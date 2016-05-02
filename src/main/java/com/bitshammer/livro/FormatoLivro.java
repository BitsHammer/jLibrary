/**
 * 
 */
package com.bitshammer.livro;

/**
 * @author Bruno
 *
 */
public enum FormatoLivro {
	
	CAPADURA("Capa dura",1),
	BROCHURA("Brochura",2 );
	
	/**
	 * Formato
	 */
	private String formato;
	private int id;

	/**
	 * Construtor
	 * @param formato
	 */
	
	private FormatoLivro(String formato,int id) {
		this.formato = formato;
		this.id=id;
	}
	public static FormatoLivro byId(int id) {
		for (FormatoLivro formato : values()) {
			if(formato.getId()==id){
				return formato;
			}			
		}
		return null;
	}
	
	public int getId() {		
		return id;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return formato;
	}
	
	
	

}
