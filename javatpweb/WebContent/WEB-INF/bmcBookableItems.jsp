<%@page import="entity.People"%>
<%@page import="entity.BookableTypes"%>
<%@page import= "controllers.CtrlBookingTypes" %>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.BookableItems"%>

<jsp:include page="../navbar.jsp"></jsp:include>
<jsp:include page="../control.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificacion Elemento</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
 <div class="col-md-6 col-md-offset-1">
     <h1>Modificacion de un elemento</h1>
     <hr>
     <form class="form-group" action="EliminarBookableItems" method="post">
         <div class="form-group">
             <input type="text" class="form-control" name="id" readonly ="readonly" placeholder="ID..." required value = "<%=((BookableItems)request.getAttribute("bi")).getId() %>">
         </div>
         <div class="form-group">
             <input type="text" class="form-control" name="nombre" placeholder="Nombre..." required value = "<%=((BookableItems)request.getAttribute("bi")).getNombre() %>">
         </div>
         
          <div class="form-group">
                 <select name="tipoElemento" class="form-control">
                 <% CtrlBookingTypes ctrl = new CtrlBookingTypes();
 					ArrayList<BookableTypes> booktypes = ctrl.getAll();

                 	for(BookableTypes bt: booktypes){
                 	%>
                 	
                 	<%if(bt.getId() == ((BookableItems)request.getAttribute("bi")).getId_tipoElemento()){ %>
                 	<option value="<%=bt.getId()%>" Selected = "selected"> <%=bt.getNombre()%> </option>
                 	
                 	<%} else{ %> <option value= "<%=bt.getId() %>" > <%=bt.getNombre()%> </option>
                 	<%} %>
  				
      				<%} %>
               	</select>
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