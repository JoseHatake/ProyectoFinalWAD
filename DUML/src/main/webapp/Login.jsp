<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DUML - Login</title>
<% String red = request.getParameter("r"); %>
<% String err = request.getParameter("e"); %>
<% String msg = request.getParameter("m"); %>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></head>
<body>
	<div class="card" style=" width: 20rem;"><div class="col-md-offset-4" ><div class="jumbotron text-center"style="background-color: #6ADFC4;">
	<h2>Iniciar sesión</h2>
	</div></div></div>
	<% if (err != null) { %> 
		<p style="color: red;"><%= err %></p>
	<% } %>
	
	<% if (msg != null) { %> 
		<p style="color: blue;"><%= msg %></p>
	<% } %>
	<div class="container"><div class="row"><div class="col-xs-12 col-sm-12 col-md-4 well well-sm" style="background-color: #E3E0D9;">
	<form method="post" action="<%= request.getContextPath() %>/Login.do">
		<input type="hidden" name="redirigir_a" value="<%= red == null ? (request.getContextPath() + "/") : red %>">
		<input type="text"  class="form-control" placeholder="Usuario" name="usuario">
		<input type="password"   class="form-control" placeholder="Contraseña" name="clave">
		<button type="submit" class="btn btn-primary">Ingresar</button>
		</form>
		<br>
	<a href="<%= request.getContextPath() %>/Registro.jsp">Registro</a>
	</div></div></div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
