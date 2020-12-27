package br.com.ifpb.agenda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.projeto.dao.AgendaDAO;

/**
 * Servlet implementation class excluiContatoServlet
 */
@WebServlet("/excluiAgendas")
public class ExcluiAgendasServlet extends HttpServlet {

	private static final long serialVersionUID = 2L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		AgendaDAO agendaDAO = new AgendaDAO();
		String[] values = request.getParameterValues("agenda_id");
		
		if (values != null) {
			for (String value : values) {
					agendaDAO.deleteAgenda(Integer.parseInt(value));
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/agendasExcluidas.jsp");
			request.setAttribute("agendas", values);
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("logon.jsp");
		}
	}
}
