<%@page import="entity.People"%>

<%@ include file="navbar.jsp" %>
<%@ include file="control.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Tipos de elemento</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
 <div class="col-md-8 col-md-offset-1">
     <h1>Alta de un nuevo tipo de elemento</h1>
     <hr>
     <form class="form-group" action="BookableTypesServlet" method="post">
         <div class="form-group">
             <input type="text" class="form-control" name="nombre" placeholder="Nombre..." required>
         </div>
         <div class="form-group">
             <input type="number" class="form-control" name="cantReservasPendientes" placeholder="Cant. Reservas Pendientes..." required>
         </div>
			<div class="form-group">
		   		<input type="number" class="form-control" name="limite" placeholder="Límite Horas..." required>
			</div>
         <div class="form-group">
             <input type="number" class="form-control" name="dias" placeholder="Dias Anticipados..." required>
         </div>
          <div class="form-group">
             <select name="req_encargado" class="form-control">
                <option value="1">Requiere</option>
				<option value="0">No Requiere</option>
       		 </select>
       	   </div>
        <div class="form-group">
            <button type="reset" value="Reset" class="btn btn-default" >Limpiar</button>
            <input type="submit" class="btn btn-primary pull-right" name="submit" value="Cargar tipo de Elemento">
        </div>
    </form>
</div>
</div>
</body>
</html>