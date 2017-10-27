<%@page import="entity.People"%>
<%@page import="entity.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.CtrlBooking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	  <!-- El logotipo y el icono que despliega el men� se agrupan
	       para mostrarlos mejor en los dispositivos m�viles -->
	  <div class="navbar-header">
	    <button type="button" class="navbar-toggle" data-toggle="collapse"
	            data-target=".navbar-ex1-collapse">
	      <span class="sr-only">Desplegar navegaci�n</span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	      <span class="icon-bar"></span>
	    </button>
	    <a class="navbar-brand" href="#">TP Java</a>
	  </div>
	 
	  <!-- Agrupar los enlaces de navegaci�n, los formularios y cualquier
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
	          <li><a href="altaBookableTypes.jsp">Nuevo Tipo Elemento</a></li>
	           <li class="divider"></li>
	          <li><a href="bookableTypes.jsp">Lista Tipo Elemento</a></li>
	          <li class="divider"></li>
	        </ul>
	      </li>
	      <li class="dropdown">
	        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	          Reservas <b class="caret"></b>
	        </a>
	        <ul class="dropdown-menu">
	          <li><a href="altaReserva.jsp">Nueva Reserva</a></li>
	           <li class="divider"></li>
	          <li><a href="reservas.jsp">Lista Reserva</a></li>
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
			<h1><%=((People)session.getAttribute("user")).getNombre() %> sus reservas son las siguientes: </h1>
			<br>
			<table class="table table-hover">
			   <tr>
			   		<th>ID</th>
					<th>Detalle</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>ID Tipo Elemento</th>
					<th>ID Elemento</th>
					<th>ID Persona</th>
					<th></th>
				</tr>
				<%
					CtrlBooking ctrl= new CtrlBooking();
					int id_pers = ((People)session.getAttribute("user")).getId();
					ArrayList<Booking> bookings = ctrl.getReservasByPerson(id_pers);
					for(Booking b : bookings){
				%>
				<form method="POST" action="EliminarReserva">
					<tr>
						<td><%=b.getId() %><input type="hidden" name="id" value="<%=b.getId() %>"></td>
						<td><%=b.getDetalle() %><input type="hidden" name="id" value="<%=b.getDetalle() %>"></td>
						<td><%=b.getFecha() %><input type="hidden" name="id" value="<%=b.getFecha() %>"></td>
						<td><%=b.getHora() %><input type="hidden" name="id" value="<%=b.getHora() %>"></td>
						<td><%=b.getId_tipoElemento() %><input type="hidden" name="id" value="<%=b.getId_tipoElemento() %>"></td>
						<td><%=b.getId_elemento() %><input type="hidden" name="id" value="<%=b.getId_elemento() %>"></td>
						<td><%=b.getId_persona() %><input type="hidden" name="id" value="<%=b.getId_persona() %>"></td>
						<td><button type="submit" class="btn btn-danger btn-sm">ELIMINAR</button></td>
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