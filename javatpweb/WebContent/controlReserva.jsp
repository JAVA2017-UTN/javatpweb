 <%@page import ="entity.People" %> 
    <% if(((People)session.getAttribute("user")).getTipo_usuario() == 0) 
    {
    	%><jsp:forward page="WEB-INF/welcome.jsp" /><%
    }
    %>