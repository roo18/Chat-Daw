package com.fpmislata.servlets.controlador;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RestringirAcceso
 */
@WebFilter("/chat/*")
public class RestringirAccesoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RestringirAccesoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
				if (request instanceof HttpServletRequest
						&& response instanceof HttpServletResponse) {

					HttpServletRequest http_request = (HttpServletRequest) request;
					HttpServletResponse http_response = (HttpServletResponse) response;

					

					if (http_request.getSession().getAttribute("daw.chat.nick") != null) {
						// Continuamos de forma normal con la peticion
						chain.doFilter(request, response);
					} else {
						// Redireccionamos a la pagina de login
						http_response.sendRedirect(http_request.getContextPath() 
								+ "/index.html");
					}

				} else {
					// Si no es una peticion HTTP simplemente procesamos la peticion
					chain.doFilter(request, response);
				}
		
		
		
	}
		
		
	
		
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
