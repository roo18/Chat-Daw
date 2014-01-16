package com.fpmislata.servlets.controlador;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/LoginUsuarioServlet")
public class LoginUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = -702692997050321714L;

         @Override
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		ServletContext sc = getServletContext();

		String nick = req.getParameter("nick");
		
		if(nick!=null && nick!="") {
			session.setAttribute("daw.chat.nick", nick);

			try {
				RequestDispatcher rd = getServletConfig().getServletContext().getRequestDispatcher("/chat/chatFrames.html");
				rd.forward(req, res);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			RequestDispatcher rd = sc.getRequestDispatcher("/index.html");
			rd.forward(req, res);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException
	{
		doGet(req,res);
	}
}
