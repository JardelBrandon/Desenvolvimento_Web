<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoContato" var="linkServletNovoContato"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda - Novo Contato</title>
</head>
<body onLoad='showResult();'>
	
	<form action="${linkServletNovoContato}" method="post">
	
		Nome: <input type="text" name="nome"  id='nome' required/>
		Telefone: <input type="text" name="telefone" id='telefone' required/>
		
		<input type="submit" value="Enviar"/>
	</form>
	
	<script>
	function myFunction() {
	  alert("The form was submitted");
	}
	</script>
	
	
	<form action="/agenda_JSTL/mainMenu.html">
		<input type="submit" value="Voltar">
	</form>

</body>
</html>