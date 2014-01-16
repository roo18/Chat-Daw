package com.fpmislata.servlets.controlador;

import com.fpmislata.modelo.ColaMensajes;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;




@WebListener
public class MiContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ColaMensajes cola=new ColaMensajes();
		ServletContext contexto=arg0.getServletContext();
		contexto.setAttribute("cola", cola);

	}

}
