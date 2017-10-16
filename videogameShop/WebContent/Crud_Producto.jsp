<%@page import="model.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="dao.DAOProducto"%>
<%@ page import="dao.DAOProducto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Panel de Administraci�n</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container">
		<h2>Listado de PRODUCTOS</h2>
		<p>La lista de producto y su acciones son las siguientes:</p>
		<p>
		<button type="button" class="btn btn-success" onclick="location.href='nuevo_producto.jsp' ">A�adir Producto</button>
		</p>
		<table class="table" id="tabla_admin">
			<thead>
				<tr>
					<th>NOMBRE</th>
					<th>PLATAFORMA</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<% DAOProducto d = new DAOProducto(); //out.print(d.findAll());
	//d.findAll();
	Vector<Producto> listProducto = d.findAll();   
	for (Producto producto : listProducto) {
		out.print("<tr>");
		out.print("<td>"+producto.getNombre()+"</td>");
		out.print("<td>"+producto.getPlataforma()+"</td>");
		out.print("<td><a href='modificar_producto.jsp?id="+producto.getId_producto()+"'>Modificar</a>");
		out.print("&nbsp | &nbsp<a href='servlet_producto?operacion=baja&id="+producto.getId_producto()+"'>Borrar</a><tr>");
    }
%>

			</tbody>
		</table>
	</div>
	<%@include  file="Footer.html" %>
</body>
</html>