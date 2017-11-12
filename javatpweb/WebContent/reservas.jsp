<%@page import="entity.People"%>
<%@page import="entity.Booking"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.CtrlBooking"%>

<%@ include file="navbar.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservas</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
		 <div class="col-md-12 col-md-offset-1">
			<h1><%=((People)session.getAttribute("user")).getNombre() %> sus reservas son las siguientes: </h1>
			<br>
			<table class="table table-hover">
			   <tr>
			   		<th>ID</th>
					<th>Detalle</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>ID Tipo Elemento</th>
					<th>ID Elemento</th>
					<th>ID Persona</th>
					<th></th>
				</tr>
				<%
					CtrlBooking ctrl= new CtrlBooking();
					int id_pers = ((People)session.getAttribute("user")).getId();
					ArrayList<Booking> bookings = ctrl.getReservasByPerson(id_pers);
					for(Booking b : bookings){
				%>
				<form method="POST" action="EliminarReserva">
					<tr>
						<td><%=b.getId() %><input type="hidden" name="id" value="<%=b.getId() %>"></td>
						<td><%=b.getDetalle() %><input type="hidden" name="id" value="<%=b.getDetalle() %>"></td>
						<td><%=b.getFecha() %><input type="hidden" name="id" value="<%=b.getFecha() %>"></td>
						<td><%=b.getHora() %><input type="hidden" name="id" value="<%=b.getHora() %>"></td>
						<td><%=b.getId_tipoElemento() %><input type="hidden" name="id" value="<%=b.getId_tipoElemento() %>"></td>
						<td><%=b.getId_elemento() %><input type="hidden" name="id" value="<%=b.getId_elemento() %>"></td>
						<td><%=b.getId_persona() %><input type="hidden" name="id" value="<%=b.getId_persona() %>"></td>
						<td><button type="submit" class="btn btn-danger btn-sm">ELIMINAR</button></td>
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