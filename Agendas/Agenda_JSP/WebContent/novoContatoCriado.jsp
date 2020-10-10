<%@ page import= "br.com.ifpb.jsp.Contato"%>
<%
	Contato contato = (Contato) request.getAttribute("contato");
	String nomeContato = contato.getNome(), telefoneContato = contato.getTelefone();
	System.out.println("nome contato: " + nomeContato);
	System.out.println("telefone contato: " + telefoneContato);
%>


<html>
<body onLoad='showResult();'>
	<h1>Cadastro de contato na pagina JSP: </h1>
	<p style=color:'blue'>Contato: <%=(nomeContato)%> Telefone: <%=(telefoneContato)%> Adicionado com Sucesso! </p>
	<script>
		function showResult() {
       		alert("Contato cadastrado com sucesso!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=/agenda_JSP/mainMenu.html'><!-- redirects after 3 seconds -->