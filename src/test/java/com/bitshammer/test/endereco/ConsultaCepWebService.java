/**
 * 
 */
package com.bitshammer.test.endereco;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.bitshammer.comum.Endereco;
import com.bitshammer.webservice.CepInvalidoException;
import com.bitshammer.webservice.IConsultaCepWebService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Bruno
 *
 */
public class ConsultaCepWebService implements IConsultaCepWebService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bitshammer.webservice.IConsultaCepWebService#consultarCep(java.lang.
	 * String)
	 */
	@Override
	public Endereco consultarCep(String cep)	 throws CepInvalidoException, Exception {
		URL url = new URL(String.format("http://viacep.com.br/ws/%s/json/", cep));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		StringBuilder builder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String output;
		while ((output = br.readLine()) != null) {
			builder.append(output);
		}
		conn.disconnect();
		if (builder.toString() == null || builder.toString().contains("erro")) {
			throw new CepInvalidoException();
		}
		Gson gson = new GsonBuilder().create();
		Endereco endereco = gson.fromJson(builder.toString(), Endereco.class);
		return endereco;
	}

}
