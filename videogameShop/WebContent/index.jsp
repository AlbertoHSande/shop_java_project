<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
	<title>Videogame Shop</title>
	<meta charset="UTF-8">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@include  file="header1.html" %>
	
	<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<h3 class="text-center">
				Videojuegos
			</h3>
			<div class="row">
			<c:forEach var="juego" items="${listaproducto}">
				<div class="col-md-4">
					<div class="thumbnail">
						<img alt="Bootstrap Thumbnail First" src="./images/${juego.id_producto}.jpg" onerror="this.src='./images/no_image.jpg';" />
						<div class="caption">
							<h3>
								${juego.nombre}
							</h3>
							<h4>${juego.plataforma}</h4>
							<p>
								${juego.descripcion}
							</p>
							<p>
								<a class="btn btn-primary" href="#">Comprar ${juego.precio}€</a> <a class="btn" href="servlet_producto?operacion=listar&id=${juego.id_producto}">Más detalles</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
</div>
	<%@include  file="Footer.html" %>
</body>