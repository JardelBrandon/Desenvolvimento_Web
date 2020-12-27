<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/loginUsuario" var="linkServletLoginUsuario"/>
<c:url value="/formNovoUsuario.jsp" var="linkNovoUsuario"/>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core">

<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<h:body>
	<div class="container">
		<div class="box">
			<h1>Acessar conta</h1>
			<form action="${linkServletLoginUsuario}" method="post">
				<h:outputLabel value="ISBN:" for="isbn" />
					<h:inputText id="isbn" value="#{livroBean.livro.isbn}" 
					 />
				<p>Email</p>
				<input type="text" placeholder="Email" name="email" required>
				<p>Senha</p>
				<input type="password" placeholder="Senha" name="senha"required> 
				<input type="submit" value="Login"> 
				<br> <a href="${linkNovoUsuario}">Criar nova conta</a>
			</form>
		</div>
	</div>
</h:body>
</html>