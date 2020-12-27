package br.com.ifpb.contato;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import br.com.ifpb.util.Genero;

/**
 * Servlet implementation class NovoAgendaServlet
 */
@WebServlet("/novoContato")
public class NovoContatoServlet extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nomeContato = request.getParameter("nome");
		Genero genero = Genero.valueOf(request.getParameter("genero"));
		String dataDeNascimento = request.getParameter("data");
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = null;
		try {
			dataDeNascimento = format2.format(format1.parse(dataDeNascimento));
			System.out.println(dataDeNascimento);
			parsed = format2.parse(dataDeNascimento);
			System.out.println(parsed.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int agendaId = Integer.parseInt(request.getParameter("agenda_id"));
		int usuarioId = Integer.parseInt(request.getParameter("usuario_id"));
		
		Contato contato = new Contato();
		contato.setNome(nomeContato);
		contato.setGenero(genero);
		contato.setDataDeNascimento(new java.sql.Date(parsed.getTime()));
		AgendaDAO agendaDAO = new AgendaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.getUsuario(usuarioId);
		Agenda agenda = agendaDAO.getAgenda(agendaId, usuario);
		contato.setAgenda(agenda);
		
		ContatoDAO contatoDAO = new ContatoDAO();		
		if (contatoDAO.createContato(contato)) {
			List<Contato> contatos = contatoDAO.getContatos(agenda);
			request.setAttribute("agenda", agenda);
			request.setAttribute("contatos", contatos);
			RequestDispatcher rd = request.getRequestDispatcher("/abreAgenda.jsp");
			rd.forward(request, response);
		} else {
		    response.sendRedirect("erroCadastroContato.jsp");
	    }
		
		
	}
}

