<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Empleado</title>
</head>
<body>
		
	<table border="1px solid black">
		<tr>
			<td>Nombre: </td>
			<td>DNI: </td>
			<td>Sexo: </td>
			<td>Categoria: </td>
			<td>Años: </td>
		</tr>
			<tr>
				<td>${emp.nombre}</td>
				<td>${emp.dni}</td>
				<td>${emp.sexo}</td>
				<td>${emp.categoria}</td>
				<td>${emp.anyos}</td>
			</tr>	
	</table>
	
	<a href="/"><button type="submit">Pagina principal</button></a>
</body>