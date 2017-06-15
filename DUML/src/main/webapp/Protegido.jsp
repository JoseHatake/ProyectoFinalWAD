<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ejemplo de documento protegido</title>
</head>
<body>
	<h1>Bienvenido: <%= session.getAttribute("Usuario.nombre") %></h1>
	<a href="<%= getServletContext().getContextPath() %>/Logout.do">Cerrar sesión</a>
</body>
</html>