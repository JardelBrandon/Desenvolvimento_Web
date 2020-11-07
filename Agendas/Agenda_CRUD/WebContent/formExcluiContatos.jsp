<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.ifpb.crud.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Excluir</title>
</head>
<body>
	<form action="/agenda_CRUD/excluiContatos" method="post">
		
		<ul>
	
		<c:forEach items="${contatos}" var="contato">
			<input type="checkbox" id="contato" name="contatoId" value='${contato.getId()}'/>
			<label>${contato.getNome()} : ${contato.getTelefone()}</label><br>
		</c:forEach>
		
		</ul>
		<input type="submit" value="Submit">
	</form>
		
	<form action="/agenda_CRUD/mainMenu.html">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>