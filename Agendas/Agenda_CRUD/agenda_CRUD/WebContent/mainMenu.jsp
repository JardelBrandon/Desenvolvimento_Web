<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/formNovoContato.jsp" var="linkNovoContato"/>
<c:url value="/listaContatos" var="linkServletListaContatos"/>
<c:url value="/mainMenu.html" var="linkMainMenu"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1> Agenda telefônica </h1>
	<form action="${linkServletListaContatos}" method="post">
		<input type="submit" value="Exibir Contatos" name="listar" />
	</form>

	<form action="${linkNovoContato}">
		<input type="submit" value="Cadastrar" />
	</form>

	<form action="${linkServletListaContatos}" method="post">
		<input type="submit" value="Editar" name="editar" />
	</form>

	<form action="${linkServletListaContatos}" method="post">
		<input type="submit" value="Excluir" name="excluir" />
	</form>

</body>
</html>