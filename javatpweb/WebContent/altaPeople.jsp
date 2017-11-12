<%@page import="entity.People"%>

<%@ include file="navbar.jsp" %>

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