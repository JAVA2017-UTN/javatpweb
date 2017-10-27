<%@page import="java.util.ArrayList"%>
<%@page import="entity.BookableTypes"%>
<%@page import ="entity.People" %>
<%@page import="controllers.CtrlBookingTypes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Tipos de Elementos</title>
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
          <li><a href="altaBookableItems.jsp">Nuevo Elemento</a></li>
           <li class="divider"></li>
          <li><a href="bookableItems.jsp">Lista Elementos</a></li>
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
		 <div class="col-md-6 col-md-offset-1">
			<h1>Lista de Tipos de Elementos</h1>
			<br>
		<table class="table table-hover">
			   <tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Cant. Maxima de Reservas</th>
				</tr>
				<%
					CtrlBookingTypes ctrl= new CtrlBookingTypes();
					ArrayList<BookableTypes> listaBt= ctrl.getAll();
					for(BookableTypes bt : listaBt){
				%>
				<form class="form-group" action="SeleccionaBookableTypes" method="post">
				<tr>
					<td><%=bt.getId() %><input type="hidden" name= "id" value = "<%=bt.getId() %>"></td>
					<td><%=bt.getNombre() %><input type="hidden" name= "nombre" value = "<%=bt.getNombre() %>"></td>
					<td><%=bt.getCantReservasPendientes() %><input type="hidden" name= "cantReservasPendientes" value = "<%=bt.getCantReservasPendientes() %>"></td>
					<td>
   					<button type="submit" class="btn btn-default btn-sm" id="deleteBtn">Seleccionar</button>
	
					</td>
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