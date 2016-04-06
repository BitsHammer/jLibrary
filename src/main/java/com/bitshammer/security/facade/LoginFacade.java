package com.bitshammer.security.facade;

import javax.faces.context.FacesContext;
import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpSession;

import com.bitshammer.cliente.Cliente;
import com.bitshammer.cliente.dao.ClienteDao;
import com.bitshammer.cliente.dao.IClienteDao;
import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.dao.LoginDao;
import com.bitshammer.security.model.TipoUsuario;
import com.bitshammer.security.model.Usuario;

public class LoginFacade implements ILoginFacade {

	private ILoginDao dao = new LoginDao();
	
	private IClienteDao clienteDao = new ClienteDao();

	@Override
	public void login(Usuario usuario) throws LoginException {
		usuario = dao.findUser(usuario);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("usuario", usuario);
		if(usuario.getTipoUsuario().equals(TipoUsuario.CLIENTE)){
			Cliente cliente = clienteDao.findByUser(usuario);
			session.setAttribute("cliente", cliente);
		}
	}

}
