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
<form action="cargarListadoDirectores" method="post">

	<input type="submit" value="ver listado">

</form>

	<form action="/insertarDirector" method="post">
		<span>Name:</span> <input type="text" name="name"> <br />
		<input type="submit" value="InsertarDirector">
	</form>


<%

List<Director> directores  = (List<Director>)request.getAttribute("listAllDirectores");

 pageContext.setAttribute("directores", directores);

%>

<table border="1">



	<thead>
		<tr>
			<td>Cod Director</td>
			<td>Nombre Director</td>
			<td>Borrar</td>
		</tr>
	</thead>
	<tbody>
	
	

		<c:forEach var="director" items="${listAllDirectores}">
			<tr>
				<td><c:out value="${director.cod}"/> </td>
				<td><c:out value="${director.name}"/> </td>
				<td><a href="/borrarDirector?cod=${director.cod}">DELETE</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>