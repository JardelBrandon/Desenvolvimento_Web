<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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

<meta http-equiv='refresh' content='3;URL=/agenda_JSTL/mainMenu.html'><!-- redirects after 3 seconds -->