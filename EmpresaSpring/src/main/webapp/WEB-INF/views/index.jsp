<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="container">
	<ul>
		<form action="/empleados" method="get">
			<li>Ver todos los empleados <input type="submit" value="Mostrar" name="accion"></li>
		</form>
		<form action="/nomina" method="get">
			<li>Ver salario de un empleado especifico <input type="text" name="dni"><input type="submit" value="SalarioEspecifico" name="accion"></li>
		</form>
		<li>Modificar empleado  
			<a href="altaEmpleados.jsp"><button type="submit">Alta Empelado</button></a>
		</li>
		<form action="/altaEmpleados" method="get">
			<li>A�adir empleado<input type="submit" value="altaEmpleado"></li>
		</form> 
		</ul>	
		
</div>
	
		

</body>
</html>