<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.projeto.model.Agenda"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/excluiAgendas" var="linkServletExcluiAgendas"/>
<c:url value="/logon.jsp" var="linkLogon"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Excluir</title>
</head>
<body>
	<h1> Excluir agendas: </h1>
	<form action="${linkServletExcluiAgendas}" method="post">
		
		<ul>
	
		<c:forEach items="${agendas}" var="agenda">
			<input type="checkbox" id="agenda" name="agenda_id" value='${agenda.getId()}'/>
			<label>${agenda.getNome()}</label><br>
		</c:forEach>
		
		</ul>
		<input type="submit" value="Excluir">
	</form>
		
	<form action="${linkLogon}">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>