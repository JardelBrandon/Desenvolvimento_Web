package br.com.ifpb.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovoContatoServlet
 */
@WebServlet("/novoContato")
public class NovoContatoServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nomeContato = request.getParameter("nome");
		String telefoneContato = request.getParameter("telefone");
		
		Contato contato = new Contato();
		contato.setNome(nomeContato);
		contato.setTelefone(telefoneContato);
		
		Banco banco = new Banco();
		banco.adiciona(contato);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/novoContatoCriado.jsp");
		request.setAttribute("contato", contato);
		rd.forward(request, response);
		
		
		
	}

}

