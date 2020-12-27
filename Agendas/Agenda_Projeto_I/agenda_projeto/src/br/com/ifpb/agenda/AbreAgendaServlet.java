package br.com.ifpb.agenda;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.projeto.dao.AgendaDAO;
import br.com.ifpb.projeto.dao.ContatoDAO;
import br.com.ifpb.projeto.dao.UsuarioDAO;
import br.com.ifpb.projeto.model.Agenda;
import br.com.ifpb.projeto.model.Contato;
import br.com.ifpb.projeto.model.Usuario;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/abreAgenda")
public class AbreAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("agendaId");
		
		if (paramId != null) {
			int id = Integer.valueOf(paramId);
			
			int usuaroId = Integer.parseInt(request.getParameter("usuario_id"));
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.getUsuario(usuaroId);
			
			AgendaDAO agendaDAO = new AgendaDAO();
			Agenda agenda = agendaDAO.getAgenda(id, usuario);
			
			ContatoDAO contatoDAO = new ContatoDAO();
			List<Contato> contatos = contatoDAO.getContatos(agenda);
			
			request.setAttribute("agenda", agenda);
			request.setAttribute("contatos", contatos);
			
			RequestDispatcher rd = request.getRequestDispatcher("/abreAgenda.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("logon.jsp");
		}
	}

}
