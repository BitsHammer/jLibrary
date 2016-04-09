package com.bitshammer.autor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutorMock {
	
	private static AutorMock INSTANCE;  
	
	public List<Autor> listaAutor; 
	
	private AutorMock(){
		listaAutor = new ArrayList<>();
		Autor a = new Autor();
		a.setNome("Stephen King");
		a.setDtNascimento(new Date());
		a.setId(1);
		Autor b = new Autor();
		b.setNome("George RR Martin");
		b.setDtNascimento(new Date());
		b.setId(2);
		listaAutor.add(a);
		listaAutor.add(b);
	}

	public static AutorMock getInstance(){
		if(INSTANCE == null)
			INSTANCE = new AutorMock();
		return INSTANCE;
	}
}
