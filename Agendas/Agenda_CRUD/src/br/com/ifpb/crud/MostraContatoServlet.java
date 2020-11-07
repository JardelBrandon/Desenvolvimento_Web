package br.com.ifpb.crud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/mostraContato")
public class MostraContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("contatoId");
		int id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Contato contato = banco.buscaContatoPeloId(id);
		
		System.out.println("Nome: " + contato.getNome());
		
		request.setAttribute("contato", contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraContato.jsp");
		rd.forward(request, response);
	}

}
