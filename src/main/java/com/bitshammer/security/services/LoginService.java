/**
 * 
 */
package com.bitshammer.security.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import com.bitshammer.security.dao.ILoginDao;
import com.bitshammer.security.dao.impl.LoginDao;
import com.bitshammer.security.model.Role;
import com.bitshammer.security.model.Usuario;

/**
 * @author Bruno
 *
 */
public class LoginService implements LoginModule {

	private CallbackHandler handler;

	private Subject subject;

	private Usuario user;


	private ILoginDao dao = new LoginDao();

	/**
	 * @see javax.security.auth.spi.LoginModule#initialize(javax.security.auth.Subject,
	 *      javax.security.auth.callback.CallbackHandler, java.util.Map,
	 *      java.util.Map)
	 */
	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		handler = callbackHandler;
		this.subject = subject;
	}

	/**
	 * @see javax.security.auth.spi.LoginModule#login()
	 */
	@Override
	public boolean login() throws LoginException {
		Callback[] callbacks = new Callback[2];
		callbacks[0] = new NameCallback("login");
		callbacks[1] = new PasswordCallback("password", true);

		try {
			handler.handle(callbacks);
			String name = ((NameCallback) callbacks[0]).getName();
			String password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());

			user = dao.findUser(name, password);
			return true;
		} catch (LoginException e) {
			// Logar
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @see javax.security.auth.spi.LoginModule#commit()
	 */
	@Override
	public boolean commit() throws LoginException {
		subject.getPrincipals().add(user);
		user.getRoles().forEach(e -> subject.getPrincipals().add(e));
		return true;
	}

	/**
	 * @see javax.security.auth.spi.LoginModule#abort()
	 */
	@Override
	public boolean abort() throws LoginException {
		return false;
	}

	/**
	 * @see javax.security.auth.spi.LoginModule#logout()
	 */
	@Override
	public boolean logout() throws LoginException {
		subject.getPrincipals().remove(user);
		user.getRoles().forEach(e-> subject.getPrincipals().remove(e));
		return true;
	}

}
