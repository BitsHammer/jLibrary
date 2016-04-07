package com.bitshammer.relatorio;

public enum TipoRelatorio {
	
	LIVRO_MAIS_VENDIDO("Por livro mais vendido"),
	CLIENTE_MAIS_COMPRA("Por cliente que mais compra"),
	AUTORES_LIVROS_MAIS_SOLICITADOS("Por autos com livros mais solicitados");
	
	private String descricao;
	
	private TipoRelatorio(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}

}
