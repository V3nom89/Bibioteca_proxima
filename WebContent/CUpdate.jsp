<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import=" java.util.ArrayList,java.util.ArrayList, model.Cliente, dao.ClienteDao" %>
			 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualizziamo i dati </title>
</head>
<body>
		
<form action="ClientServ" method="get">
<% 	
Cliente c = (Cliente) session.getAttribute("listaClienti");
%>
<table border="1px">
	<thead>
		<tr><th>Id</th><th>Nome</th><th>Cognome</th><th>Numero</th></tr>
		</thead>
	
<%    
		


	%>

	<thead >
		<tr>
			



			
			<td> <%  out.print(c.getIdcliente()); %> </td>
			<td> <%  out.print(c.getNome()); %> </td>
			<td> <%  out.print(c.getCognome()); %> </td>
			<td> <%  out.print(c.getNumero()); %>  </td> 
		

</form>
</body>
</html>