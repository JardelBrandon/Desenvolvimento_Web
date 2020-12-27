<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/logon.jsp" var="linkLogon"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<h1>Cadastro de agenda na pagina JSP: </h1>

	<c:if test="${not empty agenda}">
		<p>Agenda ${agenda.getNome()} cadastrada com sucesso!</p>
	</c:if>

	<c:if test="${empty agenda}">
		<p>Agenda nao cadastrada!</p>
	</c:if>
	
	<script>
		function showResult() {
	   		alert("Agenda  ${agenda.getNome()} cadastrado com sucesso!");
		}
	</script>
	
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkLogon}'><!-- redirects after 3 seconds -->