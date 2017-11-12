<%@page import="entity.People"%>
<%@page import="entity.BookableTypes"%>

<jsp:include page="../navbar.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificacion Tipos de elemento</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <div class="col-md-6 col-md-offset-1">
     <h1>Modificacion de un nuevo tipo de elemento</h1>
     <hr>
     <form class="form-group" action="ModificarBookableTypes" method="post">
         <div class="form-group">
             <input type="text" class="form-control" name="id" readonly ="readonly" placeholder="ID..." required value = "<%=((BookableTypes)request.getAttribute("bt")).getId() %>">
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="nombre" placeholder="Nombre..." required value = "<%=((BookableTypes)request.getAttribute("bt")).getNombre() %>">
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="cantReservasPendientes" placeholder="Cant. Reservas Pendientes..." required value = "<%=((BookableTypes)request.getAttribute("bt")).getCantReservasPendientes() %>">
        </div>
        <div class="form-group">
            
           	<input type="submit" class="btn btn-primary pull-left" name="eliminar" value="Eliminar">
      

            <input type="submit" class="btn btn-primary pull-right" name="modificar" value="Modificar">
        </div>
        
    </form>
</div>
</div>
</body>
</html>