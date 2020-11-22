<%@ page import= "br.com.ifpb.crud.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/mainMenu.jsp" var="linkMainMenu"/>
<%
	String[] contatos =  (String[]) request.getAttribute("contatos");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<h1>Contatos excluidos: </h1>
	<%
	if(contatos != null) {
		for(String contato : contatos) { %>
			<p> Contato removido com Sucesso! </p>
		<%}
	}
	%>
	<script>
		function showResult() {
       		alert("Contato(s) excluido(s) com sucesso!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkMainMenu}'><!-- redirects after 3 seconds -->