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
    }
}
