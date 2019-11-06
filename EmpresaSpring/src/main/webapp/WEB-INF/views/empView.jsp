<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Empleado</h2>
    <table>
        <tr>
            <td>Nombre :</td>
            <td>${empleado.nombre}</td>
        </tr>
        <tr>
            <td>Dni :</td>
            <td>${empleado.dni}</td>
        </tr>
        <tr>
            <td>Sexo :</td>
            <td>${empleado.sexo}</td>
        </tr>
        <tr>
            <td>Categoria :</td>
            <td>${empleado.categoria}</td>
        </tr>
        <tr>
            <td>Anyos :</td>
            <td>${empleado.anyos}</td>
        </tr>
    </table>
</body>
</html>