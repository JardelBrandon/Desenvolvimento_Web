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


@WebServlet("/alteraAgenda")
public class AlteraAgendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeAgenda = request.getParameter("nome");
		int idAgenda = Integer.parseInt(request.getParameter("id"));
		int idUsuario = Integer.parseInt(request.getParameter("usuario_id"));
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getUsuario(idUsuario);
		
		
		AgendaDAO agendaDAO = new AgendaDAO();
		Agenda agenda = agendaDAO.getAgenda(idAgenda, usuario);
		String nomeAntigo = agenda.getNome();
		agenda.setNome(nomeAgenda);
		agenda.setUsuario(usuario);
		
		agendaDAO.updateAgenda(agenda, idAgenda);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/agendaAlterada.jsp");
		request.setAttribute("agenda", agenda);
		request.setAttribute("nomeAntigo", nomeAntigo);
		rd.forward(request, response);
	}

}
