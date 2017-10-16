<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div id="wrapper">
		<div id="header">
			<h1>Nuevo Producto</h1>
			<h2>Paso 01 - Nuevo Producto</h2>
		</div>
		<div id="main">
			<form action="servlet_producto?operacion=alta" method="post">

				<div class="form-group">
					<label for="nombre">Nombre Producto:</label> <input type="text"
						class="form-control" id="nombre" name="nombre" required="required">

				</div>

				<p>
					<label for="plataforma">Plataforma</label><br> <select
						class="selectpicker" id="plataforma" name="plataforma">
						<option value="PS4" selected="selected">PS4</option>
						<option value="XBoxOne">XBox One</option>
						<option value="NintendoSwitch">Nintendo Switch</option>
						<option value="PC">PC</option>
					</select>
				</p>

				<p>
					<label for="categoria">Categoría</label><br> <select
						class="selectpicker" id="categoria" name="categoria">
						<option value="Deporte" selected="selected">Deporte</option>
						<option value="Rol">Rol</option>
						<option value="Accion">Acción</option>
						<option value="Shooter">Shooter</option>
					</select>
				</p>
				<div class="form-group">
					<label for="stock">Stock:</label> <input type="number"
						class="form-control" id="stock" name="stock" required="required">
				</div>

				<div class="form-group">
					<label for="precio">Precio:</label> <input type="number"
						class="form-control" id="precio" name="precio"
						pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required="required">
				</div>

				<div class="form-group">
					<label for="fecha">Fecha:</label> <input type="date"
						class="form-control" id="fecha" name="fecha" required="required">
				</div>

				<div class="form-group">
					<label for="descripcion">Descripción:</label>
					<textarea class="form-control" rows="5" id="descripcion"
						name="descripcion" required="required"></textarea>
				</div>
				<button type="submit" class="btn btn-success">Añadir</button>

			</form>
		</div>
	</div>
	<%@include  file="Footer.html" %>
</body>
</html>