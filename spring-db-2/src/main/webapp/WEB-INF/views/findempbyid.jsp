<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
 
	
	<div align="center">
		<form action="editemp" method="get">

			<label for="fname"> Enter The Emp Id:</label><br> <input type="text"
				id="lname" name="empid"><br>
				 <input type="hidden"  name="check" value="findempbyid">
			<br> <input type="submit" value="Submit">
		</form>
	</div>



</body>
</html>