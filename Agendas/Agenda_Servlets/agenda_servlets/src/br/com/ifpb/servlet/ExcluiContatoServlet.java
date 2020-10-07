package br.com.ifpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
		System.out.println("Excluindo contato");
		
		Banco banco = new Banco();
		List<Contato> lista = banco.getContatos();
		List<Contato> contatosExcluir = new ArrayList<Contato>();
		
		String[] values = request.getParameterValues("contato");
		for(String value : values) {
        	System.out.println(value);
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
		String val="Contatos removido com sucesso!";
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet NewServlet</title>");            
        out.println("</head>");
        out.println("<body onLoad=\"showResult();\">");
        out.println("<script>");
        out.println("function showResult(){");
        out.println("alert(\""+val+"\")");
        out.println("}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

 
        out.println("<meta http-equiv='refresh' content='3;URL=/agenda_servlets/mainMenu.html'>");//redirects after 3 seconds
        for(Contato contato: contatosExcluir) {
        	out.println("<p style='color:blue;'>Contato: " + contato.getNome() + "\nTelefone: " + contato.getTelefone() + "\n\nRemovido com Sucesso! </p>");
        }
    }
}
