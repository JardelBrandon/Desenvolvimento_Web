<%@page import="br.com.ifpb.projeto.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.projeto.model.Agenda"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	if (usuario == null) {
		response.sendRedirect("login.jsp");
	}
%>
<c:url value="/abreAgenda" var="linkServletAbreAgenda"/>
<c:url value="/logon.jsp" var="linkLogon"/>
<!DOCTYPE html>
<html>
<head>
<title>Agenda - Listagem</title>
</head>
<body>
	<h1> Lista agendas: </h1>
	
	<form action="${linkServletAbreAgenda}" method="post">
		
		<ul>
	
		<c:forEach items="${agendas}" var="agenda">
			<input type="radio" id="agenda" name="agendaId" value='${agenda.getId()}'/>
			<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
			<label>${agenda.getNome()}</label><br>
		</c:forEach>
		
		</ul>
		<input type="submit" value="Abrir">
	</form>	
	
	<form action="${linkLogon}">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>
