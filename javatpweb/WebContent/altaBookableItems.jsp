<%@page import="entity.People"%>
<%@page import="entity.BookableTypes"%>
<%@page import= "controllers.CtrlBookingTypes" %>
<%@page import="java.util.ArrayList"%>

<%@ include file="navbar.jsp" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta elemento</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <div class="col-md-6 col-md-offset-1">
     <h1>Alta de un nuevo elemento</h1>
     <hr>
     <form class="form-group" action="AltaBookableItems" method="post">
         <div class="form-group">
             <input type="text" class="form-control" name="nombre" placeholder="Nombre..." required>
         </div>
         
         <div class="form-group">
                 <select name="tipoElemento" class="form-control">
                 <% CtrlBookingTypes ctrl = new CtrlBookingTypes();
 					ArrayList<BookableTypes> booktypes = ctrl.getAll();

                 	for(BookableTypes bt: booktypes){
                 	%>
                 	<option value="<%=bt.getId()%>"><%=bt.getNombre()%></option>

      				<%} %>
               	</select>
        </div> 
         
        <div class="form-group">
            <button type="reset" value="Reset" class="btn btn-default" >Limpiar</button>
            <input type="submit" class="btn btn-primary pull-right" name="submit" value="Cargar Elemento">
        </div>
    </form>
</div>
</div>
</body>
</html>