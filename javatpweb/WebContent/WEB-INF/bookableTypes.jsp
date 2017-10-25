<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AMBC Tipos Elementos</title>
</head>
<body>

<h1>Resgistro de tipos de elementos</h1>
   
       <form class="form-group" name="ABMCTipoElementos" action="bookableTypesServlet.java" method="post">
      
         Id: <input type = "text" name = "id" />
         <br>
         <br>
         Nombre: <input type = "text" name = "nombre" />
         <br>
         <br>
         Cantidad maxima de reservas: <input type = "text" name = "cantReservasPendientes" />
         <br>
         <br>    
         <input type = "submit" name = "aceptarbtn" value = "Agregar" />
         
          <br>
         <br>    
         <input type = "submit" name = "Buscarbtn" value = "Buscar" />
         
      </form>
</body>
</html>