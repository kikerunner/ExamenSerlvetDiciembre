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
<div>¿Está usted seguro de Borrar a Esta Persona? (BORRARÁ LA MASCOTA ASOCIADA EN CASCADA)</div> 
<form action="/borrar" method="get">
		<span>ID:</span> <input type="text" name="codPersona" value="<c:out value="${personaToBorrar.codPersona}"/>"> <br />
		<span>nombre:</span> <input type="text" name="name" value="<c:out value="${personaToBorrar.name}"/>"> <br />
		<span>apellido:</span> <input type="text" name="apellido" value="<c:out value="${personaToBorrar.apellido}"/>"> <br />
		<input type="submit">
	</form>
</body>
</html>