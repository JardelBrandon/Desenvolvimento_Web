<%@ page import= "br.com.ifpb.projeto.model.Agenda"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/logon.jsp" var="linkLogon"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<h1>Agenda editado: </h1>
	Agenda: ${nomeAntigo}
	<h3>Alterado para: </h3>
	Agenda: ${agenda.getNome()}
	<script>
		function showResult() {
       		alert("Agenda alterado com sucesso!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkLogon}'><!-- redirects after 3 seconds -->