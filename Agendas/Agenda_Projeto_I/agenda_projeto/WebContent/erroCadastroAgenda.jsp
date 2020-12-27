<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/login.jsp" var="linkLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv='refresh' content='3;URL=${linkLogin}'><!-- redirects after 3 seconds -->
<meta charset="ISO-8859-1">
<title>Falha no cadastro</title>
</head>
<body onLoad='showResult();'>
	<script>
		function showResult() {
       		alert("Erro ao cadastrar!");
		}
 	</script>
</body>
</html>

