<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/logon.jsp" var="linkLogon"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='refresh' content='3;URL=${linkLogon}'><!-- redirects after 3 seconds -->
<meta charset="ISO-8859-1">
<title>Falha no cadastro</title>
</head>
<body onLoad='showResult();'>
	<h2>Aten��o!</h2>
	<h3>Necess�rio haver no m�nimo um propriet�rio</h3>
	<script>
		function showResult() {
       		alert("Erro ao cadastrar!");
		}
 	</script>
</body>
</html>
