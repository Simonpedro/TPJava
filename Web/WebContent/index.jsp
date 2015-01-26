<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Principal</title>
</head>
<body>
	<h1>Inicio</h1>
	<form action="ListaElectrodomesticos" method="post">
		<select name="consumos">
			<option value="All" selected>All</option>
			<option value="A" >A</option>
			<option value="B" >B</option>
			<option value="C" >C</option>
			<option value="D" >D</option>
			<option value="E" >E</option>
			<option value="F" >F</option>
		</select>
		Precio Desde: <input type="text" name="precioDesde" >
		Precio Hasta: <input type="text" name="precioHasta" >
		<input type="submit" name="submit" value="Listar" />
	</form>
<%= request.getAttribute("msj")==null?" ":request.getAttribute("msj") %>
</body>
</html>