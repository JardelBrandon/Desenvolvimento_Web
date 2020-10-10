<% 
	String nomeEmpresa = (String)request.getAttribute("empresa");
	System.out.println("nome empresa: "+nomeEmpresa);
%>


<html>
<body>
<h1>Cadastro de empresa na pagina JSP: </h1>
<p>Empresa  <%=(nomeEmpresa)%> cadastrada com sucesso!</p>
</body>
</html>
