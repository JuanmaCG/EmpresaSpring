<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="/empleados" method="POST" modelAttribute="empleado">
		<form:label path="nombre">Nombre: </form:label> <form:input path="nombre"></form:input><br>
		<form:label path="dni">Dni: </form:label> <form:input path="dni"></form:input><br>
		<form:label path="sexo">Sexo: </form:label> <form:input path="sexo"></form:input><br>
		<form:label path="categoria">Categoria: </form:label> <form:input path="categoria"></form:input><br>
		<form:label path="anyos">Anyos: </form:label> <form:input path="anyos"></form:input><br>
		
		<input type="submit" value="DarDeAlta">
	</form:form>
	<br><a href="/"><button type="submit">Pagina principal</button></a>
</body>
</html>