29 lines (28 sloc)  769 Bytes
<%@page import="java.util.ArrayList"%>
<%@page import="entity.People"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Bienvenido <%=((People)session.getAttribute("user")).getNombre() %></h1>
	<table>
		<%
			ArrayList<People>listaPers= (ArrayList<People>)request.getAttribute("listaPersonas");
			for(People p : listaPers){
		%>
		<tr>
			<td><%=p.getDni() %></td>
			<td><%=p.getApellido() %></td>
			<td><%=p.getNombre() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>