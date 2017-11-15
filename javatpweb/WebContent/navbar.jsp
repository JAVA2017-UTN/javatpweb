<%@page import ="entity.People" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% session = request.getSession();
	People user = (People)session.getAttribute("user");
if(user == null) {
	%><jsp:forward page="login.html" /><%
}
else {
	%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
    <link href="css/stylesPropios.css" rel="stylesheet">
</head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/stylesPropios.css">
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
    <% if(((People)session.getAttribute("user")).getTipo_usuario() == 0) 
    {
    %>
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
      <%
      }
      %>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
          Reservas <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
            <% if(((People)session.getAttribute("user")).getTipo_usuario() != 0) 
			    {
		    %>
          <li><a href="seleccionTipoEle.jsp">Nueva Reserva</a></li>
           <li class="divider"></li>
           <% }
			%>
          <li><a href="reservas.jsp">Lista Reserva</a></li>
          <li class="divider"></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a>Bienvenido/a al sistema<span class="nombre-usuario"> <%=((People)session.getAttribute("user")).getNombre() %></span></a></li>
      <li><a href="LogoutServlet" class="btn-sesion">Cerrar Sesión</a></li>
    </ul>
  </div>
</nav>

</body>
</html>
<% }
%>