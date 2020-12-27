<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoUsuario" var="linkServletNovoUsuario"/>
<c:url value="/login.jsp" var="linkLogin"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo cadastro</title>
</head>
    <body>
        <div class="container">
            <div class="regbox box">
                <h1> Criar novo conta</h1>
				<form action="${linkServletNovoUsuario}" method="post">
					<p>Nome</p>
					<input type="text" placeholder="Nome" name="nome" required>
					<p>Email</p>
					<input type="email" placeholder="Email" name="email" required>
					<p>Senha</p>
					<input type="password" placeholder="Senha" name="senha" required>
					<input type="submit" value="Cadastrar">
					<br> <a href="${linkLogin}">Já possuí um cadastro?</a>
                </form>
			</div>
		</div>
	</body>
</html>