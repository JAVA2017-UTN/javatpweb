<%@page import="entity.People"%>
<%@page import="entity.Booking"%>
<%@page import="entity.BookableItems"%>
<%@page import="entity.BookableTypes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.CtrlBookingTypes" %>
<%@page import="controllers.CtrlBookableItems" %>

<%@ include file="navbar.jsp" %>
<%@ include file="controlReserva.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seleccion de Tipo de Elemento</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	
<div class="container">
 <div class="col-md-6 col-md-offset-1">
     <h1>Alta de una nueva reserva</h1>
     <hr>
     <h3>Seleccione un tipo de elemento a reservar: </h2>
     <form class="form-group" action="SeleccionarTipoElemento" method="post">
   			<div class="form-group">
                 <select name="tipo_elemento" class="form-control">
                 <% 
                 CtrlBookingTypes ctrl = new CtrlBookingTypes();
                 ArrayList<BookableTypes> listbt = ctrl.getAll();
                 ArrayList<BookableTypes> listaReduc = ctrl.getAllReduc();
                 if(((People)session.getAttribute("user")).getTipo_usuario() == 1) {
                 	for(BookableTypes bt : listbt) {
                 %>
                 	<option value="<%=bt.getId() %>"><%=bt.getNombre()%></option>
                 <%
                 }
                 }
                 else {
                	 for(BookableTypes lr : listaReduc) {
                		 %>
                      		<option value="<%=lr.getId() %>"><%=lr.getNombre()%></option>
                      	<%
                	 }
                 }
                 %>
		       </select>
      		</div>
        <div class="form-group">
            <input type="submit" class="btn btn-primary pull-right" name="submit" value="Elegir">
        </div>
    </form>
</div>
</div>
</body>
</html>