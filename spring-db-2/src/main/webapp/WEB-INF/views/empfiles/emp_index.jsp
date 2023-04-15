<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
MSG----> ${msg}  
 <h1>Employee Login Page</h1>
	
	<div align="center">
		<form action="checkempname" method="get">

			<label for="fname">Enter The Name:</label><br> <input type="text"
				id="lname" name="empname"><br>
				 
			<br> <input type="submit" value="Submit">
		</form>
	</div>



</body>
</html>