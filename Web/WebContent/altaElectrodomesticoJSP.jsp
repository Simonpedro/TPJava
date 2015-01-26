<%@page import="entidades.Color"%>
<%@page import="negocio.ColorLogic"%>
<%@page import="negocio.ConsumoLogic"%>
<%@page import="entidades.Consumo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<Consumo> consumos= new ConsumoLogic().getAll();
ArrayList<Color> colores= new ColorLogic().getAll();
%>
 <h1>Nuevo Electrodomestico</h1>
 <form action="GuardarElectrodomestico.do" method="post">
 	Precio Base:<input type="text" name="precioBase">
 	Peso: <input type="text" name="peso">
 	Consumo: 
 	<select name="consumo">
 		<%for(int i=0; i<consumos.size();i++) 
 		{
 	    	char l = consumos.get(i).getLetraConsumo();
 			out.println("<option value=\""+l+"\">"+l+"</option>");
 	    } %>
 	</select>
 	Color:
 	<select name="color">
 		<%for(int i=0; i<colores.size();i++) 
 		{
 	    	String c = colores.get(i).getNombreColor();
 			out.println("<option value=\""+c+"\">"+c+"</option>");
 	    } %>
 	</select>
 	<%
 		String te= request.getParameter("tipoElectrodomestico");
 		if(te.equalsIgnoreCase("Televisor")) {
 			out.println("Sintonizador TDT: <input type=\"checkbox\" name=\"sintonizador\">");
 			out.println("Resolucion: <input type=\"text\" name=\"resolucion\">");
 		}
 		else if(te.equalsIgnoreCase("Lavarropas")) {
 			out.println("<input type=\"text\" name=\"carga\">");
 			
 		}
 	%>
 	<input type="hidden" name="tipoElec" value=<%= "\"" + request.getParameter("tipoElectrodomestico") +"\"" %>>
 	<input type="submit" name="submit" value="Aceptar" />
 </form>
 <%= request.getAttribute("msj") %>
</body>
</html>