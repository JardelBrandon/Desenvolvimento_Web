<%@ page import= "br.com.ifpb.projeto.model.Contato"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/login.jsp" var="linkLogin"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sucesso!</title>
</head>
<body onLoad='showResult();'>
	<script>
		function showResult() {
       		alert("Usuario Cadastrado!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=${linkLogin}'><!-- redirects after 3 seconds -->