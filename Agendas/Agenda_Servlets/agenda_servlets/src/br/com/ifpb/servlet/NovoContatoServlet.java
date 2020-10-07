package br.com.ifpb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		System.out.println("Cadastrando novo contato");
		
		String nomeContato = request.getParameter("nome");
		String telefoneContato = request.getParameter("telefone");
		Contato contato = new Contato();
		contato.setNome(nomeContato);
		contato.setTelefone(telefoneContato);
		
		Banco banco = new Banco();
		banco.adiciona(contato);
		
		
		
		PrintWriter out = response.getWriter();
		String val="Contato " + contato.getNome() + " cadastrado com sucesso";
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
        out.println("<p style='color:blue;'>Contato: " + contato.getNome() + "\nTelefone: " + contato.getTelefone() + "\n\nAdicionado com Sucesso! </p>");
		
	
	}

}
