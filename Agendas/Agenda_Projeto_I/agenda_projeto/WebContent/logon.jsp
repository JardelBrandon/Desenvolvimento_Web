<%@page import="br.com.ifpb.projeto.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	if (usuario == null) {
		response.sendRedirect("login.jsp");
	}
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/formNovaAgenda.jsp" var="linkNovaAgenda"/>
<c:url value="/listaAgendas" var="linkServletListaAgendas"/>
<c:url value="/logoutUsuario" var="linkServletLogoutUsuario"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1>
		Olá, <%=usuario.getNome()%>!
	</h1>
	<h2>
		Gerencie suas agendas
	</h2>
	<form action="${linkServletListaAgendas}" method="post">
		<input type="submit" value="Exibir Agendas" name="listar" />
		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
	</form>

	<form action="${linkNovaAgenda}">
		<input type="submit" value="Cadastrar" />
	</form>

	<form action="${linkServletListaAgendas}" method="post">
		<input type="submit" value="Editar" name="editar" />
		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
	</form>

	<form action="${linkServletListaAgendas}" method="post">
		<input type="submit" value="Excluir" name="excluir" />
		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
	</form>
	
	<form action="${linkServletLogoutUsuario}" method="post">
		<input type="submit" value="Sair" name="sair" />
	</form>
</body>
</html>