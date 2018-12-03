<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Mascota creada con exito
	<br>
	<b><%= request.getParameter("namePet") %></b>
	<b><%= request.getParameter("codPersona") %></b><br>
	<a href="/ListarPersonas.jsp"> Ir a la lista</a><br>
	<a href="/index.jsp"> Insertar más personas</a><br>
	
	
</body>
</html>