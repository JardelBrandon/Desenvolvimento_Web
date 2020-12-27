package br.com.ifpb.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.projeto.dao.UsuarioDAO;
import br.com.ifpb.projeto.model.Usuario;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/novoUsuario")
public class NovoUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		//make user object
		Usuario usuario = new Usuario(nome, email, senha);

		//create a database model
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.createUsuario(usuario)) {
		   response.sendRedirect("novoUsuarioCriado.jsp");
		} else {
		    response.sendRedirect("erroCadastroUsuario.jsp");
	    }

	}

}
