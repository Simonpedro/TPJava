<%@page import="negocio.Peso_PrecioLogic"%>
<%@page import="entidades.Electrodomestico"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Electrodomesticos</title>
</head>
<body>
<h1>Listado de electrodomesticos</h1>
<table>
<tr>
  <td><strong>Id Electrodomestico</strong></td>
  <td><strong>Peso</strong></td>
  <td><strong>Color</strong></td>
  <td><strong>Consumo</strong></td>
  <td><strong>Precio Base</strong></td>
  <td><strong>Precio Final</strong></td>
  <td><strong>Descripcion</strong></td>
  <td><strong>Detalle</strong></td>
</tr>
 <%
 	ArrayList<Electrodomestico> elecs =(ArrayList<Electrodomestico>) request.getAttribute("elecs");
    Peso_PrecioLogic controladorPesoPrecio = new Peso_PrecioLogic();
    for(int i=0; i<elecs.size();i++) {
    	Electrodomestico elec = elecs.get(i);
    	
    	out.println("<tr>");
    	out.println("<td>"+ elec.getIdElectrodomestico()+"</td>");
    	out.println("<td>"+ elec.getPeso()+"</td>");
    	out.println("<td>"+ elec.getColor()+"</td>");
    	out.println("<td>"+ elec.getConsumo()+"</td>");
    	out.println("<td>"+ elec.getPrecioBase()+"</td>");
    	out.println("<td>"+ elec.precioFinal(controladorPesoPrecio.encuentraPesoPrecio(elec.getPeso()))+"</td>");
    	out.println("<td>"+ elec.getDescripcion()+"</td>");
    	out.println("<td>"+ elec.getDetalle()+"</td>");
    	out.println("<td>");
      	out.println("<form action=\"ModificarElectrodomestico.do\" method=\"post\">");
      	out.println("<input type=\"submit\" name=\"submit\" value=\"Editar\" />");	
      	out.println("<input type=\"hidden\" name=\"idElec\" value=\"" + elec.getIdElectrodomestico() +"\">");	
      	out.println("</form>");
        out.println("</td>");
        out.println("<td>");
      	out.println("<form action=\"EliminarElectrodomestico.do\" method=\"post\">");
      	out.println("<input type=\"submit\" name=\"submit\" value=\"Eliminar\" />");	
      	out.println("<input type=\"hidden\" name=\"idElec\" value=\"" + elec.getIdElectrodomestico() +"\">");	
      	out.println("</form>");
        out.println("</td>");
    	out.println("</tr>");
    }
 %>
 </table>
 <form action="AltaElectrodomestico" method="post">
 	<input type="submit" name="submit" value="Agregar">
 	 nuevo 
 	<select name="tipoElectrodomestico">
 		<option value="Lavarropas">Lavarropas</option>
 		<option value="Televisor">Televisor</option>
 	</select>
 </form>
</body>
</html>