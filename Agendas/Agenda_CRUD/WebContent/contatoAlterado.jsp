<%@ page import= "br.com.ifpb.crud.Contato"%>

<html>
<body onLoad='showResult();'>
	<h1>Editar contato: </h1>
	Contato: ${nomeAntigo} - Telefone: ${telefoneAntigo }
	<h3>Alterado para: </h3>
	Contato: ${contato.getNome() } - Telefone: ${contato.getTelefone() }
	<script>
		function showResult() {
       		alert("Contato alterado com sucesso!");
		}
 	</script>
</body>
</html>

<meta http-equiv='refresh' content='3;URL=/agenda_CRUD/mainMenu.html'><!-- redirects after 3 seconds -->