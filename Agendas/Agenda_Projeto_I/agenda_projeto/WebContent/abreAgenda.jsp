<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="br.com.ifpb.projeto.model.Contato"%>
<%@page import="br.com.ifpb.projeto.model.Usuario"%>
<%@page import="br.com.ifpb.projeto.model.Agenda"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	Usuario usuario = (Usuario) session.getAttribute("loginUsuario");
	if (usuario == null) {
		response.sendRedirect("login.jsp");
	}
	Agenda agenda = (Agenda) request.getAttribute("agenda");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novoContato" var="linkServletNovoContato"/>
<c:url value="/novoTelefone" var="linkServletNovoTelefone"/>
<c:url value="/listaAgendas" var="linkServletListaAgendas"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda aberta</title>
</head>
<body>
	
	<h1>Agenda: ${agenda.nome}</h1>
	<form action="${linkServletNovoContato}" method="post">
		<fieldset>
			<legend>Contato</legend>
			Nome <input type="text" name="nome" placeholder="nome" required> 
			<br>
			Genero    
			<input type="radio" name="genero" value="MASCULINO" required/> Masculino
    		<input type="radio" name="genero" value="FEMININO"/> Feminino
    		<br>
    		Data de Nascimento <input type="date" name="data" placeholder="data de nascimento" pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}">
    		<br><br>
    		<input type="hidden" name="agenda_id" value="<%=agenda.getId()%>"/>
    		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
    		<input type="submit" value="Cadastrar"/>
		</fieldset>
	</form>
	<form action="${linkServletNovoTelefone}" method="post">
		<fieldset>
			<legend>Telefone</legend>
			<table> 
				<tr>
					<td>  
						<fieldset>
							<legend>Identificação</legend>
							DDD <input type="text" name="ddd" placeholder="ddd">
							Numero <input type="text" name="numero" placeholder="numero">
						</fieldset>
					 </td> 
					 <td>
						<fieldset>	
							<legend>Proprietários</legend>
						 	<div style="overflow: auto; border: 1px solid black; background-color: grey; width: 250px; height: 300px; color: white; text-align: center;">
				
							<c:forEach items="${contatos}" var="contato">
								<input type="checkbox" id="contato" name="contato_id" value='${contato.getId()}'/>
								<label>${contato.getNome()}</label><br>
							</c:forEach>
							</div>
						</fieldset>	
					</td>
				</tr>
			</table>
			<input type="hidden" name="agenda_id" value="<%=agenda.getId()%>"/>
    		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
			<input type="submit" value="Cadastrar"/>
		</fieldset>
	</form>
	<br>
	
	<sql:setDataSource var="connection" driver="com.mysql.cj.jdbc.Driver"
     url="jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_46fc30ee9372392?useTimezone=true&serverTimezone=UTC"
     user="b9c527b3c4c2d6"  password="9761ec43"/>
 
	<sql:query dataSource="${connection}" var="result">
	SELECT contatos.id, contatos.nome, contatos.genero, DATE_FORMAT(contatos.dataDeNascimento, "%d/%m/%Y") as dataDeNascimento,
		 telefones.id AS telefones_id, telefones.ddd AS telefones_ddd, telefones.numero AS telefones_numero 
		 FROM contatos
		 JOIN contatos_telefones on (contatos.id=contatos_telefones.contato_id)
		 JOIN telefones on (telefones.id=contatos_telefones.telefone_id)
		 WHERE (contatos.agenda_id=<%=agenda.getId()%>);
	</sql:query>
	
	
	<div style="overflow: auto; border: 1px solid black; background-color: grey; width: 800px; height: 300px; color: white; text-align: center;">
		<table border = "1">
		<caption>Contatos : Telefones</caption>
		<tr>
			<td>
				<table border = "1">
				<caption>Contato</caption>
				<tr>
					<th>Nome</th>
					<th>Genero</th>
					<th>Data de Nascimento</th>
				</tr>
				<c:forEach items="${result.rows}" var="contato">
					<tr>
						<td>${contato.nome}</td>
						<td>${contato.genero}</td>
						<td>${contato.dataDeNascimento}</td>
					</tr>
				</c:forEach>
				</table>
			</td>
			<td>
				<table border = "1">
				<caption>Telefone</caption>
				<tr>
					<th>DDD</th>
					<th>Numero</th>				
				</tr>
				<c:forEach items="${result.rows}" var="telefone">
					<tr>
						<td>${telefone.ddd}</td>
						<td>${telefone.numero}</td>
					</tr>
				</c:forEach>
				</table>
			</td>
		</tr>
		</table>
	</div>
	<br>
	<form action="${linkServletListaAgendas}" method="post">
		<input type="submit" value="Voltar" name="listar" />
		<input type="hidden" name="usuario_id" value="<%=usuario.getId()%>"/>
	</form>
</body>
</html>