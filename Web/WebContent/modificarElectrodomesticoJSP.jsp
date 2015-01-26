<%@page import="entidades.Televisor"%>
<%@page import="entidades.Lavarropas"%>
<%@page import="entidades.Electrodomestico"%>
<%@page import="negocio.ColorLogic"%>
<%@page import="entidades.Color"%>
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
Electrodomestico elec =(Electrodomestico)request.getAttribute("electrodomestico");
ArrayList<Consumo> consumos= new ConsumoLogic().getAll();
ArrayList<Color> colores= new ColorLogic().getAll();
%>
 <h1>Modificar Electrodomestico</h1>
 <form action="ActualizarElectrodomestico.do" method="post">
 	<input type="hidden" name="idElec" value="<%= elec.getIdElectrodomestico()  %>">
 	<input type="hidden" name="tipoElec" value="<%= (elec instanceof Lavarropas)?"Lavarropas":"Televisor"  %>">
 	Precio Base:<input type="text" name="precioBase" value=<%= "\""+ elec.getPrecioBase()+"\"" %>>
 	Peso: <input type="text" name="peso" value=<%= "\""+ elec.getPeso() +"\"" %>>
 	Consumo: 
 	<select name="consumo">
 		<%
 		boolean b=false;
 		for(int i=0; i<consumos.size();i++) 
 		{
 	    	
 			if(consumos.get(i).getIdConsumo() == elec.getConsumo().getIdConsumo()) {
 	    		 b = true;
 	    	}
 			char l = consumos.get(i).getLetraConsumo();
 			out.println("<option value=\""+l+"\" "+(b?"selected":"")+">"+l+"</option>");
 			if(b) b=false;
 	    } %>
 	    
 	</select>
 	Color:
 	<select name="color">
 		<%
 		b= false;
 		for(int i=0; i<colores.size();i++) 
 		{	
 	    	if(colores.get(i).getIdColor() == elec.getColor().getIdColor()) {
 	    		b= true;
 	    	}
 			String c = colores.get(i).getNombreColor();
 			out.println("<option value=\""+c+"\" "+(b?"selected":"") +">"+c+"</option>");
 			if(b) b=false;
 	    } %>
 	</select>
 	<%
 		
 		if(elec instanceof Televisor) {
 			b= ((Televisor)elec).isTdt();
 			out.println("Sintonizador TDT: <input type=\"checkbox\" name=\"sintonizador\""+(b?"checked=\"checked\"":"")+">");
 			out.println("Resolucion: <input type=\"text\" name=\"resolucion\" "+"value=\""+((Televisor)elec).getResolucion()+"\">");
 		}
 		else if(elec instanceof Lavarropas) {
 			out.println("<input type=\"text\" name=\"carga\" value=\""+((Lavarropas)elec).getCarga()+"\">");
 			
 		}
 	%>
 	<input type="submit" name="submit" value="Aceptar" />
 </form>
</body>
</html>