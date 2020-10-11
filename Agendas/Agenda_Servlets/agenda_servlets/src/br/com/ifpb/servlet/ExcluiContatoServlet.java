package br.com.ifpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class excluiContatoServlet
 */
@WebServlet("/excluiContato")
public class ExcluiContatoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 2L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Contato> lista = banco.getContatos();
		List<Contato> contatosExcluir = new ArrayList<Contato>();
		
		String[] values = request.getParameterValues("contato");
		if(values != null) {
			System.out.println("Excluindo contato");
			for(String value : values) {
	        	for(Contato contato: lista) {
	        		if(contato.getNome().equals(value)) {
	        			contatosExcluir.add(contato);
	        		}
	        	}
	        }
			
			for(Contato contato : contatosExcluir) {
				banco.remove(contato);
			}
			PrintWriter out = response.getWriter();
		
			out.println("<html><body onLoad=\"showResult();\">");
			out.println("<ul>");
	
			for (Contato contato : contatosExcluir) {
				out.println("Contato " + contato.getNome() + " Excluido com sucesso! </label><br>");
			}
			out.println("</ul>");
			
			out.println("<script>");
	        out.println("function showResult(){");
	        out.println("alert(\"Contato(s) excluido(s) com sucesso!\");");
	        out.println("}");
	        out.println("</script>");
			
			out.println("</body></html>");
			out.println("<meta http-equiv='refresh' content='3;URL=/agenda_servlets/mainMenu.html'><!-- redirects after 3 seconds -->");
		}
		else {
			response.sendRedirect("mainMenu.html");
		}
	}
}
