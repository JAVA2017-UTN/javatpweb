<%@page import="java.util.ArrayList"%>
<%@page import="entity.BookableTypes"%>
<%@page import ="entity.People" %>
<%@page import="controllers.CtrlBookingTypes"%>

<%@ include file="navbar.jsp" %>
<%@ include file="control.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Tipos de Elementos</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		 <div class="col-md-12 col-md-offset-1">
			<h1>Lista de Tipos de Elementos</h1>
			<br>
		<table class="table table-hover">
			   <tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Cant. Maxima de Reservas</th>
					<th>Límite Horas</th>
					<th>Dias Anticipados</th>
					<th>Requiere Encargado</th>
				</tr>
				<%
					CtrlBookingTypes ctrl= new CtrlBookingTypes();
					ArrayList<BookableTypes> listaBt= ctrl.getAll();
					for(BookableTypes bt : listaBt){%>
					
				<form class="form-group" action="SeleccionaBookableTypes" method="post" accept-charset=utf-8>
				<tr>
					<td><%=bt.getId() %><input type="hidden" name= "id" value = "<%=bt.getId() %>"></td>
					<td><%=bt.getNombre() %><input type="hidden" name= "nombre" value = "<%=bt.getNombre() %>"></td>
					<td><%=bt.getCantReservasPendientes() %><input type="hidden" name= "cantReservasPendientes" value = "<%=bt.getCantReservasPendientes() %>"></td>
					<td><%=bt.getLimite() %><input type="hidden" name= "limite" value = "<%=bt.getLimite() %>"></td>
					<td><%=bt.getDias() %><input type="hidden" name= "dias" value = "<%=bt.getDias() %>"></td>
					<td><%=bt.isReq_encargado() %><input type="hidden" name= "req_encargado" value = "<%=bt.isReq_encargado() %>"></td>
					<td>
   					<button type="submit" class="btn btn-default btn-sm" id="selectButton">SELECCIONAR</button>
	
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