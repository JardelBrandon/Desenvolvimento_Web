package br.com.ifpb.servelet_dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/NovaEmpresaServlet")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NovaEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	} */
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando uma empresa!");
		
		String nomeEmpresa = request.getParameter("nome");
		String cnpjEmpresa = request.getParameter("cnpj");
		
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Cadastro de empresas </h1>");
		out.println("<br>Empresa " + nomeEmpresa + " cadastrada com sucesso!/</br>");
		out.println("CNPJ: " + cnpjEmpresa + " cadastrado com sucesso!");
		out.println("</body>");
		out.println("</html");
	}

}
