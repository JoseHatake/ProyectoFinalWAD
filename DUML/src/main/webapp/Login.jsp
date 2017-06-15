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
</head>
<body>
	<h1>Iniciar sesión</h1>
	<% if (err != null) { %> 
		<p style="color: red;"><%= err %></p>
	<% } %>
	
	<% if (msg != null) { %> 
		<p style="color: blue;"><%= msg %></p>
	<% } %>
	<form method="post" action="<%= request.getContextPath() %>/Login.do">
		<input type="hidden" name="redirigir_a" value="<%= red == null ? (request.getContextPath() + "/") : red %>">
		<input type="text" placeholder="Usuario" name="usuario">
		<input type="password" placeholder="Contraseña" name="clave">
		<button type="submit">Ingresar</button>
	</form>
</body>
</html>
