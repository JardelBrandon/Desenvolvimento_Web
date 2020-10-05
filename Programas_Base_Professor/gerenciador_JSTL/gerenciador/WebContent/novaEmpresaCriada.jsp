<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<h1>Cadastro de empresa na pagina JSP:</h1>

	<c:if test="${not empty empresa}">
		<p>Empresa ${empresa} cadastrada com sucesso!</p>
	</c:if>

	<c:if test="${empty empresa}">
		<p>Empresa nao cadastrada!</p>
	</c:if>
</body>
</html>
