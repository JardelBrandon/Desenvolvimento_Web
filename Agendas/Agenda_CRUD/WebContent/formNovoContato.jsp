<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoContato" var="linkServletNovoContato"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Novo Contato</title>
</head>
<body>
	<h1> Novo contato: </h1>
	
	<form action="${linkServletNovoContato}" method="post">
	
		Nome: <input type="text" name="nome"  id='nome' required/>
		Telefone: <input type="text" name="telefone" id='telefone' required/>
		
		<input type="submit" value="Enviar"/>
	</form>
	
	<form action="/agenda_CRUD/mainMenu.html">
		<input type="submit" value="Voltar">
	</form>

</body>
</html>