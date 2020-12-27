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
import br.com.ifpb.projeto.dao.UsuarioDAO;
import br.com.ifpb.projeto.model.Agenda;
import br.com.ifpb.projeto.model.Usuario;

@WebServlet("/listaAgendas")
public class ListaAgendasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		AgendaDAO agendaDAO = new AgendaDAO();
		int usuaroId = Integer.parseInt(request.getParameter("usuario_id"));
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getUsuario(usuaroId);
		List<Agenda> lista = agendaDAO.getAgendas(usuario);
		
		String listar = request.getParameter("listar");
		String excluir = request.getParameter("excluir");
		String editar = request.getParameter("editar");
		
		RequestDispatcher rd = null;
		if(listar != null) {
			rd  = request.getRequestDispatcher("listaAgendas.jsp");
		} else if (excluir != null){
			rd  = request.getRequestDispatcher("formExcluiAgendas.jsp");
		} else if (editar != null){
			rd = request.getRequestDispatcher("formEditarAgenda.jsp");
		} else {
			response.sendRedirect("logon.jsp");
		}
		request.setAttribute("agendas", lista);
		rd.forward(request, response);
	}
		
}
