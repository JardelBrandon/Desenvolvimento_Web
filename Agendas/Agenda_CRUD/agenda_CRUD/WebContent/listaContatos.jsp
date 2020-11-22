<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.ifpb.crud.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/mainMenu.jsp" var="linkMainMenu"/>
<!DOCTYPE html>
<html>
<head>
<title>Agenda - Listagem</title>
</head>
<body>
	<h1> Lista contatos: </h1>
	
	<ul>
		<c:forEach items="${contatos}" var="contato">
			<li>${contato.getNome()} - ${contato.getTelefone()}</li>		
		</c:forEach>
	
	
	</ul>		
	
	<form action="${linkMainMenu}">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>
