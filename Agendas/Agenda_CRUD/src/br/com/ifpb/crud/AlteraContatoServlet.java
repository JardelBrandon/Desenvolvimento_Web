package br.com.ifpb.crud;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/alteraContato")
public class AlteraContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando contato");
		
		String nomeContato = request.getParameter("nome");
		String telefoneContato = request.getParameter("telefone");
		String idContato = request.getParameter("id");
		
		
		Banco banco = new Banco();
		Contato contato = banco.buscaContatoPeloId(Integer.valueOf(idContato));
		String nomeAntigo = contato.getNome();
		String telefoneAntigo = contato.getTelefone();
		contato.setNome(nomeContato);
		contato.setTelefone(telefoneContato);
		

		RequestDispatcher rd = request.getRequestDispatcher("/contatoAlterado.jsp");
		request.setAttribute("contato", contato);
		request.setAttribute("nomeAntigo", nomeAntigo);
		request.setAttribute("telefoneAntigo", telefoneAntigo);
		rd.forward(request, response);
	}

}
