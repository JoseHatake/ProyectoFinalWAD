<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="card" style=" width: 20rem;">
		<div class="col-md-offset-4" >
			<div class="jumbotron text-center"style="background-color: #6ADFC4;">
				<h2>Resgistro</h2>
			</div>
		</div>
	</div>
	<%
		if (err != null) {
	%>
	<p style="color: red;"><%=err%></p>
	<%
		}
	%>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-4 well well-sm" style="background-color: #E3E0D9;">
				<form method="post" action="<%=request.getContextPath()%>/Registro.do">
					<input type="text"  class="form-control" placeholder="Login" name="login">
					<input type="password"  class="form-control" placeholder="Password" name="password">
					<input type="text"  class="form-control" placeholder="Nombre" name="nombre">
					<input type="text"  class="form-control" placeholder="Primer Apellido" name="primer_ap">
					<input type="text"  class="form-control" placeholder="Segundo Apellido" name="segundo_ap">
					<section>
						<option></option>
					</section>
					<button type="submit" class="btn btn-primary">Registrarme</button>
				</form>
				<a href="Login.jsp">Login</a>
			</div>
		</div>
	</div>
	<br>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>