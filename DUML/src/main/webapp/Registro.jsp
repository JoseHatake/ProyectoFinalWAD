<%@page import="java.util.ArrayList"%>
<%@page import="mx.ipn.escom.wad.duml.accesoDB.mapeo.Empresa"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="mx.ipn.escom.wad.duml.accesoDB.bs.EmpresaBs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Registro de usuarios</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<script type="text/javascript" src="KitchenSink/node_modules/jquery/dist/jquery.js"></script>
	<script type="text/javascript" src="js/cargaEmpresas.js"></script>
</head>
<body>
	<%
		String error = (String)request.getAttribute("error");
	%>
	<header class="card" style="width: 100%;">
		<div class="col-md-offset-0">
			<div class="jumbotron text-center" style="background-color: #6ADFC4;">
				<h1>DUML - Registro</h1>
				<div class="col-xs-12" style="background-color: #E3E0D9;">
					<ul class="pagination">
						<li><a href="index.jsp">Inicio</a></li>
						<li><a href="Login.jsp">Login</a></li>
						<li><a href="MandaInformacion?direccion=Registro.jsp&opt=1">Registro</a></li>
					</ul>
				</div>
			</div>
		</div>
	</header>

	<div class="container">
		<div class="col-md-4"></div>
		<div class="col-md-4 well well-sm" style="background-color: #E3E0D9;">
			<form method="post" action="Registro">
				<input type="text" class="form-control" placeholder="Login" maxlength="30" name="login" required>
				<input type="password" class="form-control" placeholder="Password" maxlength="256" name="password" required>
				<input type="text" class="form-control" placeholder="Nombre" maxlength="50" name="nombre" required>
				<input type="text" class="form-control" placeholder="Primer Apellido" maxlength="50" name="primer_ap" required>
				<input type="text" class="form-control" placeholder="Segundo Apellido" maxlength="50" name="segundo_ap" required>
				<div id="empresas">
					<h4>Selecciona las empresas en las que trabajas</h4>
					<%
						ArrayList<Empresa> empresas = (ArrayList<Empresa>)request.getAttribute("empresas");
						for(Empresa empresa : empresas){
							%>
						<label><%=empresa.getNombre()%></label>
						<input type="checkbox" name="empresa" value="<%=empresa.getId()%>">
						<br>
							<%
						}
					%>
				</div>
				<button type="submit" class="btn btn-primary">Registrarme</button>
			</form>
			<a href="Login.jsp">Login</a>
			<%
				if(error != null && !error.equals("")){
					%>
					<h4 style="color: red;"><%=error%></h4>
					<%
				}
			%>
		</div>
	</div>
	<div class="col-md-4"></div>
	<br>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>