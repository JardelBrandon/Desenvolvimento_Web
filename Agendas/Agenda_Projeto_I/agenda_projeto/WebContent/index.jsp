<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/login.jsp" var="linkLogin"/>
<!DOCTYPE html>
<html >
<head>
<meta http-equiv='refresh' content='5;URL=${linkLogin}'><!-- redirects after 3 seconds -->
<meta charset="ISO-8859-1">
<title>Bem vindo</title>
</head>
<body>
	<h1>Seja bem vindo!</h1>
	<h2>Aplicativo de agendas telefônicas eletrônicas</h2>
</body>
</html>