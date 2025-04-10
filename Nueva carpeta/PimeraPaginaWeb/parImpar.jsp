<%@page import="prueba.Metodos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
	int numero;
	boolean esPar;
	%>
    <%
	numero=Integer.parseInt( request.getParameter("numero"));
	esPar=Metodos.esPar(numero);
	if (esPar==true) {
		out.println("<h1> El numero " + numero +  " es par</h1>");
	}else{
		out.println("<h1> El numero " + numero +  " es impar</h1>");
	}
	%>
	
    	

</body>
</html>