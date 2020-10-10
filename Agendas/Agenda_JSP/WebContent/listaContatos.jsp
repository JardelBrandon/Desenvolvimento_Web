<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.ifpb.jsp.Contato"%>
<!DOCTYPE html>
<html>
<body>
	<ul>
		<%List<Contato> lista = (List<Contato>) request.getAttribute("contatos"); 
			for (Contato contato : lista) { 
		%>		
		
		<li><%=contato.getNome() + " : " + contato.getTelefone()%></li>
		
		<%} %>
	</ul>
	<form action="/agenda_JSP/mainMenu.html">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>
