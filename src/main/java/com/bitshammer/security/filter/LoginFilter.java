package com.bitshammer.security.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.INCLUDE
		}
					, urlPatterns = { "/pages/compra/*", "/pages/admin/*" })
public final class LoginFilter implements Filter {

    /**
     * Construtor
     */
    public LoginFilter() {}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
    @Override
	public void destroy() {}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		String uri = ((HttpServletRequest)request).getRequestURI();
		if(uri.contains(".css") || uri.contains(".js") || uri.contains(".png"))
			chain.doFilter(request, response);	
		if(session.getAttribute("usuario") != null)
			chain.doFilter(request, response);
		else ((HttpServletRequest)request).getRequestDispatcher("/login.xhtml").forward(request, response);
		
	}

	/*
	 * (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {}

}
