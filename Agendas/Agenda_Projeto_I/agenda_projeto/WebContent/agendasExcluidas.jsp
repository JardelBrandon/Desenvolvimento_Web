<%@ page import= "br.com.ifpb.projeto.model.Agenda"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/logon.jsp" var="linkLogon"/>
<%
	String[] agendas =  (String[]) request.getAttribute("agendas");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<h1>Agendas excluidas: </h1>
	<%
	if(agendas != null) {
		for(String agenda : agendas) { %>
			<p> Agenda removida com Sucesso! </p>
		<%}
	}
	%>
	<script>
		function showResult() {
       		alert("Agenda(s) excluida(s) com sucesso!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkLogon}'><!-- redirects after 3 seconds -->