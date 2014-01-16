package com.fpmislata.servlets.vistas;

import com.fpmislata.modelo.ColaMensajes;
import com.fpmislata.modelo.Mensaje;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;






import java.io.*;

@WebServlet("/ListaMensajesServlet")
public class ListaMensajesServlet extends HttpServlet {

	private static final long serialVersionUID = 427199619647569137L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		/*ServletContext sc = getServletContext();
		ColaMensajes cola= (ColaMensajes) sc.getAttribute("cola");
		req.setAttribute("es.ua.jtech.cw.chat.mensajes", cola);
		RequestDispatcher rd = sc.getRequestDispatcher("/jsp/listaMensajes.jsp");
		rd.forward(req, res);*/
		
		// ESTE ES EL CÓDIGO CON LISTA MENSAJES CON SERVLETS
		
			ServletContext sc = getServletContext();
		//  Añadir cabecera para actualizar cada 5 segundos
		res.setHeader("Refresh", "5");

		
		PrintWriter out = res.getWriter();
		RequestDispatcher rd = sc.getRequestDispatcher("/chat/cabecera.htmlf");
		rd.include(req, res);


		// Mostrar mensajes del chat
		ColaMensajes cola= (ColaMensajes) sc.getAttribute("cola");
		HttpSession session = req.getSession();
		String nick = (String)session.getAttribute("daw.chat.nick");
		for(Mensaje m:cola){
			if(nick.equals(m.getEmisor())){
				out.println("<B>");
				out.println(m.getEmisor()+": ");
				out.println("</B>");
			}
			else{	
			out.println(m.getEmisor()+": ");
			}
			out.println(m.getTexto());
			out.println("</BR>");
	
		}
		

		// Incluir /chat/pie.htmlf
		RequestDispatcher rd2 = sc.getRequestDispatcher("/chat/pie.htmlf");
		
		rd2.include(req, res);   
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
