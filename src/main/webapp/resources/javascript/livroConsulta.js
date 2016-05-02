function validarCampos(){
	var titulo=$("#consultaLoader\\:l_titulo").val();
	var editora=$("#consultaLoader\\:l_editora").val();
	var autor=$("#consultaLoader\\:l_autor").val();
	var categoria=$("#consultaLoader\\:l_categoria").val();	
	
	if(titulo=='' && editora=='' && autor=='' && categoria==''){
		alert("Digite pelo uma opção de pesquisa");
		$(titulo).focus();
		return false;
	}
	
}
