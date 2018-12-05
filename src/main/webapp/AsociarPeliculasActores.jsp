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
<form action="cargarListadoPeliculasAsociacion" method="post">

	<input type="submit" value="ver listado Peliculas">

</form>

	<form action="/insertarPelicula" method="post">
		<span>Titulo:</span> <input type="text" name="title"> <br />
		<span>CodOwner:</span> <input type="text" name="codowner"> <br />
		<input type="submit" value="InsertarPelicula">
	</form>


<%

List<Pelicula> peliculas = (List<Pelicula>)request.getAttribute("listAllPeliculas");

 pageContext.setAttribute("peliculas", peliculas);

%>

<table border="1">



	<thead>
		<tr>
			<td>Cod Pelicula</td>
			<td>Nombre Pelicula</td>
			<td>CodOWner</td>
			<td>Crear Relacion entre Peliculas y actores</td>
			<td>Borrar</td>
		</tr>
	</thead>
	<tbody>
	
	

		<c:forEach var="pelicula" items="${listAllPeliculas}">
			<tr>
				<td><c:out value="${pelicula.cod}"/> </td>
				<td><c:out value="${pelicula.title}"/> </td>
				<td><c:out value="${pelicula.codOwner}"/> </td>
				<td><a href="/relacionarPelicula?cod=${pelicula.cod}">Asociar Peliculas Actores</a> </td>
				<td><a href="/borrarPelicula?cod=${pelicula.cod}">DELETE</a> </td>
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>