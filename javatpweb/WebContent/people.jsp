<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.People"%>
<%@page import="controllers.CtrlABMPeople"%>

<%@ include file="navbar.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Persona</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		 <div class="col-md-12 col-md-offset-1">
			<h1>Lista de Personas</h1>
			<br>
			<table class="table table-hover">
			   <tr>
			   		<th>ID</th>
					<th>DNI</th>
					<th>Apellido</th>
					<th>Nombre</th>
					<th>Usuario</th>
					<th>Contraseña</th>
					<th>Habilitado</th>
					<th>Tipo Usuario</th>
					<th></th>
				</tr>
				<%
					CtrlABMPeople ctrl= new CtrlABMPeople();
					ArrayList<People> listaPers= ctrl.getAll();
					for(People p : listaPers){
				%>
				<form method="POST" action="SeleccionaPersona">
					<tr>
					
						<td><%=p.getId() %><input type="hidden" name="id" value="<%=p.getId() %>"></td>
						<td><%=p.getDni() %><input type="hidden" name="dni" value="<%=p.getDni() %>"></td>
						<td><%=p.getApellido() %><input type="hidden" name="apellido" value="<%=p.getApellido() %>"></td>
						<td><%=p.getNombre() %><input type="hidden" name="nombre" value="<%=p.getNombre() %>"></td>
						<td><%=p.getUsuario() %><input type="hidden" name="user" value="<%=p.getUsuario() %>"></td>
						<td><%=p.getContrasenia() %><input type="hidden" name="contra" value="<%=p.getContrasenia() %>"></td>
						<td><%=p.isHabilitado() %><input type="hidden" name="estado" value="<%=p.isHabilitado() %>"></td>
						<td><%=p.getTipo_usuario_String() %><input type="hidden" name="tipo_usu" value="<%=p.getTipo_usuario() %>"></td>
						<td><button type="submit" class="btn btn-default btn-sm">SELECCIONAR</button></td>
					</tr>
				</form>
				<%
					}
				%>
			</table>
	</div>
	</div>
</body>
</html>