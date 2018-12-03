<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*" %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cargarListado" method="post">

	<input type="submit" value="ver listado">

</form>

	<form action="/insertar" method="post">
		<span>Name:</span> <input type="text" name="name"> <br />
		<span>YearOfBirthDate:</span> <input type="text" name="yearofbirthdate"> <br />
		<input type="submit" value="InsertarActor">
	</form>


<%

List<Actor> actores = (List<Actor>)request.getAttribute("listAllPersonas");

 pageContext.setAttribute("actores", actores);

%>

<table border="1">



	<thead>
		<tr>
			<td>Cod Actor</td>
			<td>Nombre Actor</td>
			<td>YearOfBirthDate</td>
			<td>Editar</td>
			<td>Borrar</td>
		</tr>
	</thead>
	<tbody>
	
	

		<c:forEach var="persona" items="${listAllPersonas}">
			<tr>
				<td><c:out value="${persona.codPersona}"/> </td>
				<td><c:out value="${persona.name}"/> </td>
				<td><c:out value="${persona.apellido}"/> </td>
				<td><a href="/editar?codPersona=${persona.codPersona}">EDIT</a> </td>
				<td><a href="/confirmarDelete?codPersona=${persona.codPersona}">DELETE</a> </td>
				<td><a href="/addPet?codPersona=${persona.codPersona}">Añadir Mascota</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>