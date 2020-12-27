<%@page import="br.com.ifpb.projeto.model.Usuario"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	if (usuario == null) {
		response.sendRedirect("login.jsp");
	}
%>

<c:url value="/alteraAgenda" var="linkServletAlteraAgenda"/>
<c:url value="/mainMenu.jsp" var="linkMainMenu"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Editar</title>
</head>
<body>
	<h1> Editar agenda: </h1>
	
	<form action="${linkServletAlteraAgenda}" method="post">
	
		Nome: <input type="text" name="nome"  id='nome' value="${agenda.getNome()}" required/>
		<input type="hidden" name="id"  id='id' value="${agenda.getId()}"/>
		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<form action="${linkMainMenu}">
		<input type="submit" value="Voltar">
	</form>

</body>
</html>