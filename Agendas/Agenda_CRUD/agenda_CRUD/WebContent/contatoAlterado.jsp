<%@ page import= "br.com.ifpb.crud.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/mainMenu.jsp" var="linkMainMenu"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<h1>Contato editado: </h1>
	Contato: ${nomeAntigo} - Telefone: ${telefoneAntigo }
	<h3>Alterado para: </h3>
	Contato: ${contato.getNome() } - Telefone: ${contato.getTelefone() }
	<script>
		function showResult() {
       		alert("Contato alterado com sucesso!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkMainMenu}'><!-- redirects after 3 seconds -->