<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/alteraContato" var="linkServletAlteraContato"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Novo Contato</title>
</head>
<body>
	<h1> Editar contato: </h1>
	
	<form action="${linkServletAlteraContato}" method="post">
	
		Nome: <input type="text" name="nome"  id='nome' value="${contato.getNome()}" required/>
		Telefone: <input type="text" name="telefone" id='telefone' value="${contato.getTelefone()}" required/>
		<input type="hidden" name="id"  id='id' value="${contato.getId()}"/>
		<input type="submit" value="Enviar"/>
	</form>
	
	<form action="/agenda_CRUD/mainMenu.html">
		<input type="submit" value="Voltar">
	</form>

</body>
</html>