<%@page import="java.time.chrono.ChronoLocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="org.omg.CORBA.CurrentOperations"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="entity.People"%>
<%@page import="entity.Booking"%>
<%@page import="entity.BookableItems"%>
<%@page import="entity.BookableTypes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controllers.CtrlBooking"%>
<%@page import="controllers.CtrlBookingTypes"%>
<%@page import="controllers.CtrlBookableItems"%>

<%@ include file="../navbar.jsp" %>

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

<script language="JavaScript" type="text/javascript">
alert(" <%= (String)request.getAttribute("Errorlim") %>");
</script>
                          

<div class="container">
		 <div class="col-md-12 col-md-offset-1">
		    <% if(((People)session.getAttribute("user")).getTipo_usuario() == 0) 
			    {
		    %>
		    <h1><%=((People)session.getAttribute("user")).getNombre() %>, éstas son todas las reservas: </h1>
			<br>
			<table class="table table-hover">
			   <tr>
			   		<th>ID</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Tipo Elemento</th>
					<th>Elemento</th>
					<th>ID Persona</th>
					<th>Cant Horas Reservadas</th>
					<th>Detalle</th>
					<th>Anulada</th>
					<th></th>
				</tr>
				<%
					CtrlBooking ctrl= new CtrlBooking();
					ArrayList<Booking> bookings = ctrl.getList();
					CtrlBookingTypes ctrlType = new CtrlBookingTypes();
					CtrlBookableItems ctrlItem = new CtrlBookableItems();
					String nombreType;
					String nombreItem;
					for(Booking b : bookings){
						nombreType = ctrlType.getById(b.getId_tipoElemento()).getNombre();
						nombreItem = ctrlItem.getById(b.getId_elemento()).getNombre();
				%>
				<form method="POST" action="ModificarReserva">
					<tr>
						<td><%=b.getId() %><input type="hidden" name="id" value="<%=b.getId() %>"></td>
						<td><%=b.getFecha() %><input type="hidden" name="id" value="<%=b.getFecha() %>"></td>
						<td><%=b.getHora() %><input type="hidden" name="id" value="<%=b.getHora() %>"></td>
						<td><%=nombreType %><input type="hidden" name="id" value="<%=b.getId_tipoElemento() %>"></td>
						<td><%=nombreItem %><input type="hidden" name="id" value="<%=b.getId_elemento() %>"></td>
						<td><%=b.getId_persona() %><input type="hidden" name="id" value="<%=b.getId_persona() %>"></td>
						<td><%=b.getCant_horas() %><input type="hidden" name="id" value="<%=b.getCant_horas() %>"></td>
						<td><%=b.getDetalle() %><input type="hidden" name="id" value="<%=b.getDetalle() %>"></td>
						<td><%=b.isAnuladaString() %><input type="hidden" name="id" value="<%=b.isAnulada() %>"></td>
						<%
						LocalDateTime fecha = LocalDateTime.now();
						if(!b.isAnulada()) 
						{
						%>
						<td><button type="submit" class="btn btn-danger btn-sm" name="anular" value="Anular">ANULAR</button></td>
						<% 
						}
						%>
					</tr>
				</form>
				<%
					}
				%>
			</table>
			
		    <% 
		    } else {
		    	
			%>
			<h1><%=((People)session.getAttribute("user")).getNombre() %> sus reservas son las siguientes: </h1>
			<br>
			<table class="table table-hover">
			   <tr>
			   		<th>ID</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Tipo Elemento</th>
					<th>Elemento</th>
					<th>Cant Horas Reservadas</th>
					<th>Detalle</th>
					<th>Anulada</th>
					<th></th>
				</tr>
				<%
					CtrlBooking ctrl = new CtrlBooking();
					CtrlBookingTypes ctrlType = new CtrlBookingTypes();
					CtrlBookableItems ctrlItem = new CtrlBookableItems();
					String nombreType;
					String nombreItem;
					int id_pers = ((People)session.getAttribute("user")).getId();
					ArrayList<Booking> bookings = ctrl.getReservasByPerson(id_pers);
					for(Booking b : bookings){
						nombreType = ctrlType.getById(b.getId_tipoElemento()).getNombre();
						nombreItem = ctrlItem.getById(b.getId_elemento()).getNombre();
				%>
				<form method="POST" action="ModificarReserva">
					<tr>
						<td><%=b.getId() %><input type="hidden" name="id" value="<%=b.getId() %>"></td>
						<td><%=b.getFecha() %><input type="hidden" name="id" value="<%=b.getFecha() %>"></td>
						<td><%=b.getHora() %><input type="hidden" name="id" value="<%=b.getHora() %>"></td>
						<td><%=nombreType %><input type="hidden" name="id" value="<%=b.getId_tipoElemento() %>"></td>
						<td><%=nombreItem %><input type="hidden" name="id" value="<%=b.getId_elemento() %>"></td>
						<td><%=b.getCant_horas() %><input type="hidden" name="id" value="<%=b.getCant_horas() %>"></td>
						<td><%=b.getDetalle() %><input type="hidden" name="id" value="<%=b.getDetalle() %>"></td>
						<td><%=b.isAnuladaString() %><input type="hidden" name="id" value="<%=b.isAnulada() %>"></td>
						<input type="hidden" name="id" value="<%=b.getId_persona() %>">
						<%if(!b.isAnulada()) 
						{
							%>
						<td><button type="submit" class="btn btn-danger btn-sm" name="eliminar" value="Eliminar">ELIMINAR</button></td>
						<% 
						}
						%>
					</tr>
				</form>
				<%
					}
				%>
			</table>
			
			<% 
			}
			%>
	</div>
	</div>
</body>
</html>