package br.com.ifpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaContatos")
public class ListaContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Contato> lista = banco.getContatos();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<ul>");
		
		for (Contato contato : lista) {
			out.println("<li> " + contato.getNome() + ":");
			out.println(contato.getTelefone() + "</li>");
		}

		out.println("</ul>");
		out.println("<form action=\"/agenda_servlets/mainMenu.html\">\n" + 
				"		<input type=\"submit\" value=\"Voltar\"/>\n" + 
				"	</form>");
		out.println("</body></html>");
	}
}
