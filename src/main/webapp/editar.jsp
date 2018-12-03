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
<form action="/updatePersona" method="post">
		<span>ID:</span> <input type="text" name="codPersona" value="<c:out value="${personaEditar.codPersona}"/>"> <br />
		<span>nombre:</span> <input type="text" name="name" value="<c:out value="${personaEditar.name}"/>"> <br />
		<span>apellido:</span> <input type="text" name="apellido" value="<c:out value="${personaEditar.apellido}"/>"> <br />
		<input type="submit">
	</form>
</body>
</html>