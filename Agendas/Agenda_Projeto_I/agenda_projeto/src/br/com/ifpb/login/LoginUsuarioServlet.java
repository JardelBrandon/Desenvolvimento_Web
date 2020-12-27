package br.com.ifpb.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ifpb.projeto.dao.UsuarioDAO;
import br.com.ifpb.projeto.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginUsuario")
public class LoginUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginEmail = request.getParameter("email");
        String loginSenha = request.getParameter("senha");
        
        UsuarioDAO usuarioDAO =  new UsuarioDAO();
        Usuario usuario = usuarioDAO.loginUsuario(loginEmail, loginSenha);
        
        if(usuario != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUsuario", usuario);
            response.sendRedirect("logon.jsp");
        }else{
        	response.sendRedirect("erroLoginUsuario.jsp");
        }
	}

}
