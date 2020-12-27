package br.com.ifpb.telefone;

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
import br.com.ifpb.projeto.dao.TelefoneDAO;
import br.com.ifpb.projeto.dao.UsuarioDAO;
import br.com.ifpb.projeto.model.Agenda;
import br.com.ifpb.projeto.model.Contato;
import br.com.ifpb.projeto.model.Telefone;
import br.com.ifpb.projeto.model.Usuario;

/**
 * Servlet implementation class NovoAgendaServlet
 */
@WebServlet("/novoTelefone")
public class NovoTelefoneServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String ddd = request.getParameter("ddd");
		String numero = request.getParameter("numero");
		
		int agendaId = Integer.parseInt(request.getParameter("agenda_id"));
		int usuarioId = Integer.parseInt(request.getParameter("usuario_id"));
		Integer telefoneId = null;
		
		Telefone telefone = new Telefone();
		telefone.setDdd(ddd);
		telefone.setNumero(numero);
		
		AgendaDAO agendaDAO = new AgendaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getUsuario(usuarioId);
		Agenda agenda = agendaDAO.getAgenda(agendaId, usuario);
		
		ContatoDAO contatoDAO = new ContatoDAO();
		String[] values = request.getParameterValues("contato_id");
		
		TelefoneDAO telefoneDAO = new TelefoneDAO();
		if (values != null) {
			for (String value : values) {
				int contatoId = Integer.parseInt(value);
				Contato contato = contatoDAO.getContato(contatoId, agenda);
				telefone.getContatos().add(contato);
				if(telefoneId == null) {
					telefoneId = telefoneDAO.createTelefone(telefone, contatoId);
				}
				else {
					telefoneDAO.createTelefone(telefone, contatoId);
				}
			}
			for(Contato contato : telefone.getContatos()) {
				telefoneDAO.createContatoTelefone(telefoneId, contato.getId());
			}
			List<Contato> contatos = contatoDAO.getContatos(agenda);
			request.setAttribute("telefone", telefone);
			request.setAttribute("agenda", agenda);
			request.setAttribute("contatos", contatos);
			RequestDispatcher rd = request.getRequestDispatcher("/abreAgenda.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("erroCadastroTelefone.jsp");
		}	
	}
}

