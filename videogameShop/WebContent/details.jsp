<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<title>${producto.nombre}- Videogame Shop</title>
<meta charset="UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/videoclub.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:import url="header.jsp"></c:import>

	<div class="container-fluid">
		<div class="row">
			<div class="row">
				<div class="col-md-12">
					<h3>${producto.nombre}</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
				<div class="thumbnail">
					<img alt="Bootstrap Image Preview" class="imgprinci"
						src="./images/${producto.id_producto}.jpg" onerror="this.src='./images/no_image.jpg';" />
						</div>
				</div>
				<div class="col-md-4">
					<dl>
						<dt>Fecha de salida:</dt>
						<dd>${producto.fecha}</dd>
						<dt>Plataforma:</dt>
						<dd>${producto.plataforma}</dd>
						<dt>Género:</dt>
						<dd>${producto.categoria}</dd>
						<dt>Stock:</dt>
						<dd>${producto.stock}</dd>
					</dl>
					<button type="button" class="btn btn-default">Comprar ${producto.precio}€</button>
					<button type="button" class="btn btn-default">Default</button>
				</div>
				<div class="col-md-4">
					<p>
						${producto.descripcion}
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12"></div>
			</div>
		</div>
	</div>
	<%@include file="Footer.html"%>
</body>