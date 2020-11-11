<%@ page import= "br.com.ifpb.crud.Contato"%>
<%
	String[] contatos =  (String[]) request.getAttribute("contatos");
%>


<html>
<body onLoad='showResult();'>
	<h1>Excluir contato na pagina JSP: </h1>
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

<meta http-equiv='refresh' content='3;URL=/agenda_CRUD/mainMenu.html'><!-- redirects after 3 seconds -->