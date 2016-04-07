/**
 * 
 */
package com.bitshammer.relatorio.bean;

import com.bitshammer.infra.bean.DefaultBean;
import com.bitshammer.relatorio.TipoRelatorio;
import com.bitshammer.relatorio.factory.RelatorioFactory;

/**
 * @author Bruno
 *
 */
public class RelatorioBean extends DefaultBean {
	
	private TipoRelatorio tipoRelatorio;
	
	private RelatorioFactory relatorioFacotry;
	
	public void gerarRelatorio() {
		
	}

	/**
	 * @return the tipoRelatorio
	 */
	public TipoRelatorio getTipoRelatorio() {
		return tipoRelatorio;
	}

	/**
	 * @param tipoRelatorio the tipoRelatorio to set
	 */
	public void setTipoRelatorio(TipoRelatorio tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

}
