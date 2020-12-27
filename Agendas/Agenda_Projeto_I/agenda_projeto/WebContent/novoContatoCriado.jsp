<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/mainMenu.jsp" var="linkMainMenu"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<h1>Cadastro de contato na pagina JSP: </h1>

	<c:if test="${not empty contato}">
		<p>Contato ${contato.getNome()} cadastrado com sucesso!</p>
	</c:if>

	<c:if test="${empty contato}">
		<p>Contato nao cadastrado!</p>
	</c:if>
	
	<script>
		function showResult() {
	   		alert("Contato  ${contato.getNome()} cadastrado com sucesso!");
		}
	</script>
	
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkMainMenu}'><!-- redirects after 3 seconds -->