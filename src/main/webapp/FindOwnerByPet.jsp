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
	<form action="/FindResultados" method="post">
		<span>Año 1:</span> <input type="text" name="ano1"> <br />
		<span>Año 2:</span> <input type="text" name="ano2"> <br />
		<input type="submit">
	</form>
	<% 
	Director directores = (Director)request.getAttribute("listResultados");
	
	pageContext.setAttribute("director", directores);
	%>

<table border="1">
	<thead>
		<tr>
			<td>Cod Director</td>
			<td>Nombre</td>
		</tr>
	</thead>
	<c:forEach var="director" items="${listResultados}">
			<tr>
				<td><c:out value="${director.cod}"/> </td>
				<td><c:out value="${director.name}"/> </td>
	    	</tr>
		</c:forEach>
</table>
</body>
</html>