<%@page import="br.com.ifpb.projeto.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	if (usuario == null) {
		response.sendRedirect("login.jsp");
	}
%>
<c:url value="/novaAgenda" var="linkServletNovaAgenda"/>
<c:url value="/logon.jsp" var="linkLogon"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo cadastro</title>
</head>
    <body>
       	<h1> Nova Agenda: </h1>
	
		<form action="${linkServletNovaAgenda}" method="post">
		
			Nome: <input type="text" name="nome" placeholder="nome" required/>
			<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
			<input type="submit" value="Enviar"/>
		</form>
		
		<form action="${linkLogon}">
			<input type="submit" value="Voltar">
		</form>
	</body>
</html>