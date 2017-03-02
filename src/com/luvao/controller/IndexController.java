package com.luvao.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.luvao.mail.SendMailSSL;

@WebServlet({ "/Contact"})
public class IndexController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
		String alias = request.getServletPath();
		if (alias.equals("/Contact")) {
			contactoCliente(request, response);
		} 
	}
	
	protected void contactoCliente(HttpServletRequest request,
		    HttpServletResponse response) 
		    		throws ServletException, IOException {
			try {
				SendMailSSL mailSSL = new SendMailSSL();
				String nombre = request.getParameter("name");
				String email = request.getParameter("emaild");
				String asunto = request.getParameter("subject");
				String mensaje = request.getParameter("message");

				mailSSL.enviarMensaje(nombre, email, asunto, mensaje);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

}
