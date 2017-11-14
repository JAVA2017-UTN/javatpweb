<%@page import="java.util.ArrayList"%>
<%@page import="entity.BookableItems"%>
<%@page import ="entity.People" %>
<%@page import="controllers.CtrlBookableItems"%>

<%@ include file="navbar.jsp" %>
<%@ include file="control.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Elementos</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		 <div class="col-md-6 col-md-offset-1">
			<h1>Lista de de Elementos</h1>
			<br>
		<table class="table table-hover">
			   <tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Cant. Maxima de Reservas</th>
				</tr>
				<%
					CtrlBookableItems ctrl= new CtrlBookableItems();
					ArrayList<BookableItems> listaBi= ctrl.getAll();
					for(BookableItems bi : listaBi){
				%>
				<form class="form-group" action="SeleccionaItems" method="post">
				<tr>
					<td><%=bi.getId() %><input type="hidden" name= "id" value = "<%=bi.getId() %>"></td>
					<td><%=bi.getNombre() %><input type="hidden" name= "nombre" value = "<%=bi.getNombre() %>"></td>
					<td><%=bi.getId_tipoElemento() %><input type="hidden" name= "idTipoElemento" value = "<%=bi.getId_tipoElemento()%>"></td>
					<td>
   					<button type="submit" class="btn btn-default btn-sm" id="seleccionar">SELECCIONAR</button>
	
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