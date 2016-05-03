function validarCampos(){
	var nome=$("#form\\:nome").val();
	var cpf=$("#form\\:cpf").val();
	var email=$("#form\\:email").val();
	
	if(nome=='' && cpf=='' && email==''){
		alert("Digite pelo uma opção de pesquisa");
		$(nome).focus();
		return false;
	}
}