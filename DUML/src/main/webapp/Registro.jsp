<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro de usuarios</title>
<%
	String red = request.getParameter("r");
%>
<%
	String err = request.getParameter("e");
%>
</head>
<body>
	<h1>Resgistro</h1>
	<%
		if (err != null) {
	%>
	<p style="color: red;"><%=err%></p>
	<%
		}
	%>
	<form method="post" action="<%=request.getContextPath()%>/Registro.do">
		<input type="text" placeholder="Login" name="login"> <input
			type="password" placeholder="Password" name="password"> <input
			type="text" placeholder="Nombre" name="nombre"> <input
			type="text" placeholder="Primer Apellido" name="primer_ap"> <input
			type="text" placeholder="Segundo Apellido" name="segundo_ap">
		<button type="submit">Registrarme</button>
	</form>
	
	<br>
	<a href="<%=request.getContextPath()%>/Login.jsp">Login</a>
</body>
</html>