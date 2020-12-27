package br.com.ifpb.agenda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.projeto.dao.AgendaDAO;
import br.com.ifpb.projeto.dao.UsuarioDAO;
import br.com.ifpb.projeto.model.Agenda;
import br.com.ifpb.projeto.model.Usuario;

/**
 * Servlet implementation class NovoAgendaServlet
 */
@WebServlet("/novaAgenda")
public class NovaAgendaServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nomeAgenda = request.getParameter("nome");
		int usuaroId = Integer.parseInt(request.getParameter("usuario_id"));
		
		Agenda agenda = new Agenda();
		agenda.setNome(nomeAgenda);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getUsuario(usuaroId);
		agenda.setUsuario(usuario);
		
		AgendaDAO agendaDAO = new AgendaDAO();
		
		if (agendaDAO.createAgenda(agenda)) {
			RequestDispatcher rd = request.getRequestDispatcher("/novaAgendaCriada.jsp");
			request.setAttribute("agenda", agenda);
			rd.forward(request, response);
		} else {
		    response.sendRedirect("erroCadastroAgenda.jsp");
	    }
		
		
	}
}

