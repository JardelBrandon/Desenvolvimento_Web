package br.com.ifpb.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.crud.Banco;
import br.com.ifpb.crud.Contato;

/**
 * Servlet implementation class excluiContatoServlet
 */
@WebServlet("/excluiContatos")
public class ExcluiContatosServlet extends HttpServlet {

	private static final long serialVersionUID = 2L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		Banco banco = new Banco();
		List<Contato> lista = banco.getContatos();

		String[] values = request.getParameterValues("contatoId");
		
		if (values != null) {
			banco.remove(values);
			RequestDispatcher rd = request.getRequestDispatcher("/contatosExcluidos.jsp");
			request.setAttribute("contatos", values);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("mainMenu.jsp");
		}
	}
}
