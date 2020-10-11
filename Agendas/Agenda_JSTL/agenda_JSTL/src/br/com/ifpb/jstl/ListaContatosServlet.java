package br.com.ifpb.jstl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaContatos")
public class ListaContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Contato> lista = banco.getContatos();
		
		String listar = request.getParameter("listar");
		String excluir = request.getParameter("excluir");

		RequestDispatcher rd;
		if(listar != null) {
			rd  = request.getRequestDispatcher("listaContatos.jsp");
		} else {
			rd  = request.getRequestDispatcher("formExcluiContatos.jsp");
		}
		
		request.setAttribute("contatos", lista);
		rd.forward(request, response);
		
	}
		
}
