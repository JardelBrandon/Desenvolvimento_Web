<%@page import="br.com.ifpb.projeto.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.projeto.model.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	if (usuario == null) {
		response.sendRedirect("login.jsp");
	}
%>
<c:url value="/mostraAgenda" var="linkServletMostraAgenda"/>
<c:url value="/logon.jsp" var="linkLogon"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Editar</title>
</head>
<body>
	<h1> Selecionar a agenda para editar: </h1>
	<form action="${linkServletMostraAgenda}" method="post">
		
		<ul>
	
		<c:forEach items="${agendas}" var="agenda">
			<input type="radio" id="agenda" name="agendaId" value='${agenda.getId()}'/>
			<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
			<label>${agenda.getNome()}</label><br>
		</c:forEach>
		
		</ul>
		<input type="submit" value="Editar">
	</form>
		
	<form action="${linkLogon}">
		<input type="submit" value="Voltar">
	</form>
</body>
</html>