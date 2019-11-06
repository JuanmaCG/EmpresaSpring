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
    <h2>Nomina Empleado</h2>
    <table>
        <tr>
            <td>Dni :</td>
            <td>${nomina.empleado.dni}</td>
        </tr>
        <tr>
            <td>Salario :</td>
            <td>${nomina.sexo}</td>
        </tr>
    </table>
</body>
</html>