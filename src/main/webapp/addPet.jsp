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
<form action="/addPet" method="post">
		<span style="display:none">id:</span> <input type="text" name="codPersona"  value="<c:out value="${ownerPet.codPersona}"/>" style="display:none"> <br />
		<span>nombre:</span> <input type="text" name="name" value="<c:out value="${ownerPet.name}"/>"> <br />
		<span>apellido:</span> <input type="text" name="apellido" value="<c:out value="${ownerPet.apellido}"/>"> <br />
		<span>Nombre Mascota:</span> <input type="text" name="namePet"> <br />
		<input type="submit">
	</form>
</body>
</html>