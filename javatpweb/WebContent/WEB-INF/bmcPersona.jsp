<%@page import="entity.People"%>
<%@page import="controllers.CtrlABMPeople"%>

<jsp:include page="../navbar.jsp"></jsp:include>
<jsp:include page="../control.jsp"></jsp:include>
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

<div class="container">
 <div class="col-md-6 col-md-offset-1">
     <h1>Modificación de una Persona</h1>
     <hr>
     <form class="form-group" action="ModificarPersona" method="post">
         <div class="form-group">
             <input readonly="readonly" type="text" class="form-control" name="id" placeholder="ID..." value="<%=((People)request.getAttribute("persona")).getId() %>" required>
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="dni" placeholder="DNI..." value="<%=((People)request.getAttribute("persona")).getDni() %>" required>
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="nombre" placeholder="Nombre..." value="<%=((People)request.getAttribute("persona")).getNombre() %>" required>
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="apellido" placeholder="Apellido..." value="<%=((People)request.getAttribute("persona")).getApellido() %>" required>
         </div>
	<div class="form-group">
                 <input type="text" class="form-control" name="usuario" placeholder="Usuario del usuario..." value="<%=((People)request.getAttribute("persona")).getUsuario() %>" required>
             </div>
             <div class="form-group">
                 <input type="password" class="form-control" name="contrasenia" placeholder="Contraseña del usuario..." value="<%=((People)request.getAttribute("persona")).getContrasenia() %>" required>
             </div>
             <div class="form-group">
                 <select name="estado" class="form-control">
                 <% if(((People)request.getAttribute("persona")).isHabilitado() == true) {
                	 %>
                 	<option value="1" selected="selected">Habilitado</option>
 					<option value="0">No Habilitado</option>
                <%  }
                 else {
                 %>
                  	<option value="1">Habilitado</option>
 					<option value="0" selected="selected">No Habilitado</option>                
                 <%
                 } 
                 %>        
       		</select>
        </div>
        <div class="form-group">
                 <select name="tipo_usuario" class="form-control">
                 <% if(((People)request.getAttribute("persona")).getTipo_usuario() == 0) {
                	 %>
                 	<option value="0" selected="selected">Admin</option>
 					<option value="1">Encargado</option>
 					<option value="2">Usuario</option>
                <%  }
                 else if(((People)request.getAttribute("persona")).getTipo_usuario() == 1) {
                 %>
                 	<option value="0">Admin</option>
 					<option value="1" selected="selected">Encargado</option>
 					<option value="2">Usuario</option>               
                 <%
                 }
                 else if(((People)request.getAttribute("persona")).getTipo_usuario() == 2) {
                 %>
                 	<option value="0">Admin</option>
 					<option value="1" >Encargado</option>
 					<option value="2" selected="selected">Usuario</option> 
                 <%
                 }
                 %>          
       		</select>
        </div>
        <div class="form-group">
            <input type="submit" value="Eliminar" class="btn btn-danger" name="eliminar">
            <input type="submit" class="btn btn-primary pull-right" name="modificar" value="Modificar">
        </div>
    </form>
</div>
</div>
</body>
</html>