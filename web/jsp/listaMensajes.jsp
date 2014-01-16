<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="es.ua.jtech.cw.chat.to.ColaMensajes" %>
	<%@ page import="es.ua.jtech.cw.chat.to.Mensaje" %>
	<%@ include file="/chat/cabecera.htmlf" %>
	<% HttpSession s=request.getSession();
	response.setIntHeader("Refresh", 5);
	ColaMensajes cola=(ColaMensajes) request.getAttribute("es.ua.jtech.cw.chat.mensajes"); 
	String nick = (String)s.getAttribute("es.ua.jtech.cw.chat.nick");
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
	
	%>
		
	
	<%@ include file="/chat/pie.htmlf" %>
</body>
</html>