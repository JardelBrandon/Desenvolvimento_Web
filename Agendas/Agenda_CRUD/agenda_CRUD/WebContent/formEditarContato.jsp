<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.ifpb.crud.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/mostraContato" var="linkServletMostraContato"/>
<c:url value="/mainMenu.jsp" var="linkMainMenu"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Editar</title>
</head>
<body>
	<h1> Selecionar contato para editar: </h1>
	<form action="${linkServletMostraContato}" method="post">
		
		<ul>
	
		<c:forEach items="${contatos}" var="contato">
			<input type="radio" id="contato" name="contatoId" value='${contato.getId()}'/>
			<label>${contato.getNome()} : ${contato.getTelefone()}</label><br>
		</c:forEach>
		
		</ul>
		<input type="submit" value="Editar">
	</form>
		
	<form action="${linkMainMenu}">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>