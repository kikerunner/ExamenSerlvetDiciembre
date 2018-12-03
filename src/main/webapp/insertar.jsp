<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Actor creado con exito
	<br>
	<b><%= request.getParameter("name") %></b>
	<b><%= request.getParameter("yearofbirthdate") %></b><br>
	<a href="/ListarActores.jsp"> Ir a la lista</a><br>
	<a href="/index.jsp"> Volver a Index</a><br>
	
	
</body>
</html>