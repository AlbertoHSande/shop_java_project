<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="dao.DAOProducto"%>
<%@ page import="model.Producto"%>
<%@ page import="java.util.Vector"%>

<!DOCTYPE html>
<html>
<head>
<title>Modificar Producto</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/videoclub.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<%
	DAOProducto dao = new DAOProducto();
	Producto p = dao.findById(request.getParameter("id"));
%>
<!--  -->
<script>
 function myFunction() {
	document.getElementById('plataforma').value="<%=p.getPlataforma()%>";
	document.getElementById('categoria').value="<%=p.getCategoria()%>";
}
 </script>
</head>
<body onload="myFunction()">
	<div id="wrapper">
		<div id="header">
			<h1>Producto <i style="color: green;"><%out.print(p.getNombre());%></i>
			</h1>
			<h2>Modificar Producto</h2>
		</div>
		<div id="main">
			<form action="servlet_producto?operacion=modificar&id=<%=p.getId_producto()%>" method="post">

				<div class="form-group">
					<label for="nombre">Nombre Producto:</label> <input type="text"
						class="form-control" id="nombre" name="nombre" required="required"
						value="<%out.print(p.getNombre());%>">
				</div>
				<p>
					<label for="plataforma">Plataforma</label><br> <select
						class="selectpicker" id="plataforma" name="plataforma">
						<option value="PS4">PS4</option>
						<option value="XBoxOne">XBox One</option>
						<option value="NintendoSwitch">Nintendo Switch</option>
						<option value="PC">PC</option>
					</select>
				</p>
				<p>
					<label for="categoria">Categoría</label><br>
					<select class="selectpicker" id="categoria" name="categoria">
						<option value="Deporte">Deporte</option>
						<option value="Rol">Rol</option>
						<option value="Accion">Acción</option>
						<option value="Shooter">Shooter</option>
					</select>
				</p>
				<div class="form-group">
					<label for="stock">Stock:</label> <input type="number"
						class="form-control" id="stock" name="stock" required="required"
						value="<%out.print(p.getStock());%>">
				</div>

				<div class="form-group">
					<label for="precio">Precio:</label> <input type="number"
						class="form-control" id="precio" name="precio"
						pattern="[0-9]+([\.,][0-9]+)?" step="0.01" required="required"
						value="<%out.print(p.getPrecio());%>">
				</div>

				<div class="form-group">
					<label for="fecha">Fecha:</label> <input type="date"
						class="form-control" id="fecha" name="fecha" required="required"
						value="<%out.print(p.getFecha());%>">
				</div>

				<div class="form-group">
					<label for="descripcion">Descripción:</label>
					<textarea class="form-control" rows="5" id="descripcion"
						name="descripcion" required="required"><%out.print(p.getDescripcion());%></textarea>
				</div>
				<button type="submit" class="btn btn-success">Modificar</button>
				<button type="button" class="btn btn-warning" onclick="location='Crud_Producto.jsp'">Cancelar</button>
			</form>
		</div>
	</div>
</body>
</html>