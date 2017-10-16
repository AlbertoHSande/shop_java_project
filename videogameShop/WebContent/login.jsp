<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container">
		<div class="main">
			<div class="col-md-12 ">
				<div class="col-md-6">
					<h4>Registro de usuario.</h4>
					<form class="" method="post"
						action="servlet_usuario?operacion=alta">

						<div class="form-group">
							<label for="nombre" class="col-sm-2 control-label">Nombre</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="nombre" id="nombre"
										placeholder="Indique su nombre" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="apellidos" class="col-sm-2 control-label">Apellidos</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="apellidos" id="apellidos"
										placeholder="Indique su Apellidos " />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="dni" class="col-sm-2 control-label">DNI</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="dni" id="dni"
										placeholder="Indique su DNI" />
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="email" id="email"
										placeholder="Indique su Email" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="col-sm-2 control-label">Nick</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="username" id="username"
										placeholder="Indique Nombre de Usuario " />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
										type="password" class="form-control" name="password"
										id="password" placeholder="Enter your Password" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="confirm" class="col-sm-2 control-label">Confirmar
								Password</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span> <input
										type="password" class="form-control" name="confirm"
										id="confirm" placeholder="Confirm your Password" />
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" class="btn btn-success">Añadir</button>
						</div>

					</form>
				</div>

				<div class="col-md-6">
					<h4>Inicia sesion.</h4>
					<form class="" method="post" action="servlet_login">

						<div class="form-group">
							<label for="nombre" class="col-sm-2 control-label">Nombre</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="nombre" id="nombre"
										placeholder="Indique su nombre" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="apellido" class="col-sm-2 control-label">Contraseña</label>
							<div class="col-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span> <input
										type="password" class="form-control" name="contra" id="contra"
										placeholder="Indique su contraseña " />
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit" class="btn btn-success">Entrar</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
		<%@include  file="Footer.html" %>
</body>
</html>