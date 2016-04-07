package com.bitshammer.promocao.facade;

import java.util.List;

import com.bitshammer.promocao.Promocao;

public interface IPromocaoFacade {
	
	public void cadastrarPromocao(Promocao promocao);
	
	public void alterarPromocao(Promocao promocao);
	
	public void excluirPromocao(Promocao promocao);
	
	public List<Promocao> listarPromocaoPorParametros(Promocao promocao);

}
