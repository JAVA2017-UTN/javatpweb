<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.People"%>
<%@page import="controllers.CtrlABMPeople"%>
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
	<nav class="navbar navbar-default" role="navigation">
	  <!-- El logotipo y el icono que despliega el menú se agrupan
	       para mostrarlos mejor en los dispositivos móviles -->
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse"
	            data-target=".navbar-ex1-collapse">
	      <span class="sr-only">Desplegar navegación</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="#">TP Java</a>
	  </div>
	 
	  <!-- Agrupar los enlaces de navegación, los formularios y cualquier
	       otro elemento que se pueda ocultar al minimizar la barra -->
	  <div class="collapse navbar-collapse navbar-ex1-collapse">
	    <ul class="nav navbar-nav">
	          <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          Personas <b class="caret"></b>
	        </a>
	        <ul class="dropdown-menu">
	          <li><a href="altaPeople.jsp">Nueva Persona</a></li>
	           <li class="divider"></li>
	          <li><a href="people.jsp">Lista Personas</a></li>
	          <li class="divider"></li>
	        </ul>
	      </li>
	        <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          Elementos <b class="caret"></b>
	        </a>
	        <ul class="dropdown-menu">
	          <li><a href="#">Nuevo Elemento</a></li>
	           <li class="divider"></li>
	          <li><a href="people.jsp">Lista Elementos</a></li>
	          <li class="divider"></li>
	        </ul>
	      </li>
	       <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          Tipo Elementos <b class="caret"></b>
	        </a>
	        <ul class="dropdown-menu">
	          <li><a href="altaBookableTypes">Nuevo Tipo Elemento</a></li>
	           <li class="divider"></li>
	          <li><a href="BookableTypes.jsp">Lista Tipo Elemento</a></li>
	          <li class="divider"></li>
	        </ul>
	      </li>
	      <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          Reservas <b class="caret"></b>
	        </a>
	        <ul class="dropdown-menu">
	          <li><a href="#">Nueva Reserva</a></li>
	           <li class="divider"></li>
	          <li><a href="#">Lista Reserva</a></li>
	          <li class="divider"></li>
	        </ul>
	      </li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="#">Bienvenido <%=((People)session.getAttribute("user")).getNombre() %></a></li>
	      </li>
	    </ul>
	  </div>
	</nav>

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
					<th></th>
				</tr>
				<%
					CtrlABMPeople ctrl= new CtrlABMPeople();
					ArrayList<People> listaPers= ctrl.getAll();
					for(People p : listaPers){
				%>
				<form method="POST" action="EditaPersona">
					<tr>
					
						<td><%=p.getId() %><input type="hidden" name="id" value="<%=p.getId() %>"></td>
						<td><%=p.getDni() %><input type="hidden" name="dni" value="<%=p.getDni() %>"></td>
						<td><%=p.getApellido() %><input type="hidden" name="apellido" value="<%=p.getApellido() %>"></td>
						<td><%=p.getNombre() %><input type="hidden" name="nombre" value="<%=p.getNombre() %>"></td>
						<td><%=p.getUsuario() %><input type="hidden" name="user" value="<%=p.getUsuario() %>"></td>
						<td><%=p.getContrasenia() %><input type="hidden" name="contra" value="<%=p.getContrasenia() %>"></td>
						<td><%=p.isHabilitado() %><input type="hidden" name="estado" value="<%=p.isHabilitado() %>"></td>
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