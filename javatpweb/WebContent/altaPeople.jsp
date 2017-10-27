<%@page import="entity.People"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Persona</title>
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
     <h1>Alta de una nueva Persona</h1>
     <hr>
     <form class="form-group" action="AltaPersona" method="post">
         <div class="form-group">
             <input type="text" class="form-control" name="dni" placeholder="DNI..." required>
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="nombre" placeholder="Nombre..." required>
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="apellido" placeholder="Apellido..." required>
         </div>
	<div class="form-group">
                 <input type="text" class="form-control" name="usuario" placeholder="Usuario del usuario..." required>
             </div>
             <div class="form-group">
                 <input type="password" class="form-control" name="contrasenia" placeholder="Contraseña del usuario..." required>
             </div>
             <div class="form-group">
                 <select name="estado" class="form-control">
                     <option value="1">Habilitado</option>
		<option value="0">No Habilitado</option>
       </select>
        </div>
        <div class="form-group">
            <button type="reset" value="Reset" class="btn btn-default" >Limpiar</button>
            <input type="submit" class="btn btn-primary pull-right" name="submit" value="Cargar usuario">
        </div>
    </form>
</div>
</div>
</body>
</html>