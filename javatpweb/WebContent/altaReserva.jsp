<%@page import="entity.People"%>
<%@page import="entity.Booking"%>
<%@page import="entity.BookableItems"%>
<%@page import="entity.BookableTypes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="controllers.CtrlBookingTypes" %>
<%@page import="controllers.CtrlBookableItems" %>

<%@ include file="navbar.jsp" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	
<div class="container">
 <div class="col-md-6 col-md-offset-1">
     <h1>Alta de una nueva reserva</h1>
     <hr>
     <form class="form-group" action="AltaReserva" method="post" >
           	<div class="form-group">
		   		<input type="hidden" class="form-control" name="tipo_elemento" value="<%=(Integer)session.getAttribute("id_tipoEle")%>">
			</div>
   			<div class="form-group">
                 <select name="elemento" class="form-control">
                 <%
                 Calendar calendar = Calendar.getInstance();
                 int year = calendar.get(Calendar.YEAR);
                 int month = calendar.get(Calendar.MONTH)+1;
                 int day = calendar.get(Calendar.DAY_OF_MONTH)+1;
                 BookableTypes bt = new BookableTypes();
                 CtrlBookingTypes ctrlTypes = new CtrlBookingTypes();
                 bt = ctrlTypes.getById((Integer)session.getAttribute("id_tipoEle"));
                 calendar.add(Calendar.DAY_OF_MONTH, bt.getDias());
                 int yearMax = calendar.get(Calendar.YEAR);
                 int monthMax = calendar.get(Calendar.MONTH)+1;
                 int dayMax = calendar.get(Calendar.DAY_OF_MONTH);
                 CtrlBookableItems ctrlItems = new CtrlBookableItems();
                 ArrayList<BookableItems> listbi = ctrlItems.getAllByType((Integer)session.getAttribute("id_tipoEle"));
                 for(BookableItems bi : listbi) {
                 %>
                 	<option value="<%=bi.getId() %>"><%=bi.getNombre()%></option>
                 <%
                 }
                 %>
		       </select>
      		</div>
      		<div class="form-group">
		   		<input type="date" class="form-control" name="fecha" min="<%=year+"-"+month+"-"+day %>" max="<%=yearMax+"-"+monthMax+"-"+dayMax %>">
			</div>
			<div class="form-group">
		   		<input type="time" class="form-control" name="hora">
			</div>
			<div class="form-group">
		   		<input type="number" class="form-control" name="cant_horas" max="<%=bt.getLimite() %>" min="1" placeholder="Cantidad de horas a reservar...">
			</div>
         	<div class="form-group">
             <textarea style="resize:none; height:150px" type="text" class="form-control" name="detalle" placeholder="Detalle..." required> </textarea>
         	</div>
         	<div class="form-group">
		   		<input type="hidden" class="form-control" name="id_persona" value="<%=((People)session.getAttribute("user")).getId()%>">
			</div>
        <div class="form-group">
            <button type="reset" value="Reset" class="btn btn-default" >Limpiar</button>
            <input type="submit" class="btn btn-primary pull-right" name="submit" value="Cargar Reserva">
        </div>
    </form>
</div>
</div>
</body>
</html>