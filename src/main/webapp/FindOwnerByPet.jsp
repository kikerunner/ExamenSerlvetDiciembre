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
	<form action="/FindOwnerByPet" method="post">
		<span>nombre Mascota:</span> <input type="text" name="namePet"> <br />
		<input type="submit">
	</form>
	<% 
	Persona persona = (Persona)request.getAttribute("listDuenos");
	
	pageContext.setAttribute("persona", persona);
	%>

<table border="1">
	<thead>
		<tr>
			<td>Cod Persona</td>
			<td>Nombre</td>
			<td>Apellido</td>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td><c:out value="${persona.codPersona}"/> </td>
				<td><c:out value="${persona.name}"/> </td>
				<td><c:out value="${persona.apellido}"/> </td>
	    	</tr>
	</tbody>
</table>
</body>
</html>