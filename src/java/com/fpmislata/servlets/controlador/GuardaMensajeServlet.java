package com.fpmislata.servlets.controlador;

import com.fpmislata.modelo.ColaMensajes;
import com.fpmislata.modelo.Mensaje;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



import java.io.*;


@WebServlet("/GuardaMensajeServlet")
public class GuardaMensajeServlet extends HttpServlet {

	private static final long serialVersionUID = -481257371131179080L;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		
		try{ // en caso de error se redireccionrá a error.jsp
		HttpSession session = req.getSession();
		ServletContext sc = getServletContext();

		String nick = (String)session.getAttribute("daw.chat.nick");
		
		
		
		// Agregar mensaje enviado a la cola de mensajes
		String texto= req.getParameter("texto");
		Mensaje mensaje= new Mensaje(nick,texto);
		ColaMensajes cola= (ColaMensajes) sc.getAttribute("cola");
		cola.add(mensaje);
		sc.setAttribute("cola", cola);
		
		
		// Redireccionar a /chat/enviaMensaje.html
		RequestDispatcher rd= req.getRequestDispatcher("/chat/chatFrames.html");
		rd.forward(req, res);
		}
		catch(Exception e){
			RequestDispatcher rd= req.getRequestDispatcher("/jsp/error.jsp");
			req.setAttribute("error", "Error al enviar mensaje: "+e.getMessage());
			rd.forward(req, res);
			res.sendRedirect("/jsp/error.jsp");
			
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
