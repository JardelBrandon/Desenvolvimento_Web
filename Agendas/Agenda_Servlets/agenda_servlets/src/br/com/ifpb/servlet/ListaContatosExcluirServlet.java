package br.com.ifpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaContatosExcluir")
public class ListaContatosExcluirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Contato> lista = banco.getContatos();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		out.println("<form action=\"/agenda_servlets/excluiContato\" method=\"post\">");
		out.println("<ul>");

		for (Contato contato : lista) {
			out.println("<input type=\"checkbox\" id=\"contato\" name=\"contato\" value=" + contato.getNome() + ">");
			out.println("<label for=\"contato\">" + contato.getNome() + "</label><br>");
		}
		
		out.println("<input type=\"submit\" value=\"Submit\">");
		
		out.println("</ul>");
		out.println("<form action=\"/agenda_servlets/mainMenu.html\">\n" + 
				"		<input type=\"submit\" value=\"Voltar\"/>\n" + 
				"	</form>");
		out.println("</body></html>");
	}
}
