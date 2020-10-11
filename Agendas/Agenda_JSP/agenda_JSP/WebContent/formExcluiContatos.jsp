<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.ifpb.jsp.Contato"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Excluir</title>
</head>
<body>
	<form action="/agenda_JSP/excluiContatos" method="post">
		
		</ul>
	
				
		<%List<Contato> lista = (List<Contato>) request.getAttribute("contatos"); 
			for (Contato contato : lista) { 
		%>		
		
		<input type="checkbox" id="contato" name="contato" value=<%=contato.getNome()%>>
		<label><%=contato.getNome() + " : " + contato.getTelefone()%></label><br>
		
		<!-- <label for="contato">" contato.getNome() "</label><br>-->
		
		<%} %>
		
		</ul>
		<input type="submit" value="Submit">
	</form>
		
	<form action="/agenda_JSP/mainMenu.html">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>