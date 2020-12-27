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
 * Servlet implementation class MostraEmpresaServlet
 */
@WebServlet("/mostraAgenda")
public class MostraAgendaServlet extends HttpServlet {
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
			
			request.setAttribute("agenda", agenda);
			
			RequestDispatcher rd = request.getRequestDispatcher("/formAlteraAgenda.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("logon.jsp");
		}
	}

}
